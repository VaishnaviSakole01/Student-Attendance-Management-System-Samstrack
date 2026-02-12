import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
  const navigate = useNavigate();

  const [loginRequest, setLoginRequest] = useState({
    username: "",
    password: "",
  });

  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const inputHandler = (e) => {
    const { name, value } = e.target;
    setLoginRequest((prev) => ({ ...prev, [name]: value }));
  };

  const submitHandler = async (e) => {
    e.preventDefault();
    setError("");
    setLoading(true);

    // ⏱️ TIMEOUT CONTROLLER (8 seconds)
    const controller = new AbortController();
    const timeoutId = setTimeout(() => controller.abort(), 8000);

    try {
      const response = await fetch(
        "http://localhost:8091/user/login-user/",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(loginRequest),
          signal: controller.signal,
        }
      );

      clearTimeout(timeoutId);

      if (!response.ok) {
        throw new Error("Invalid username or password");
      }

      // ✅ SAFE RESPONSE HANDLING
      const text = await response.text();
      console.log("Login response:", text);

      let user = {};
      if (text) {
        user = JSON.parse(text);
      }

      const role = user.role || "ROLE_ADMIN";

      localStorage.setItem("username", loginRequest.username);
      localStorage.setItem("role", role);

      // ⏳ Small delay so user sees "Logging in..."
      setTimeout(() => {
        if (role === "ADMIN") {
          navigate("/admin-dashboard");
        } else if (role === "FACULTY") {
          navigate("/faculty-dashboard");
        } else {
          navigate("/");
        }
      }, 1000);

    } catch (err) {
      if (err.name === "AbortError") {
        setError("Server is taking too long. Please try again.");
      } else {
        setError(err.message || "Login failed");
      }
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-blue-400 via-purple-400 to-pink-400">
      <form
        onSubmit={submitHandler}
        className="bg-white rounded-lg shadow-lg p-8 w-full max-w-md flex flex-col gap-6"
      >
        <h2 className="text-2xl font-bold text-center text-blue-600">
          Login
        </h2>

        <input
          type="text"
          name="username"
          placeholder="Username"
          value={loginRequest.username}
          onChange={inputHandler}
          required
          className="border p-3 rounded"
        />

        <input
          type="password"
          name="password"
          placeholder="Password"
          value={loginRequest.password}
          onChange={inputHandler}
          required
          className="border p-3 rounded"
        />

        {error && (
          <p className="text-red-500 text-center text-sm">
            {error}
          </p>
        )}

        <button
          type="submit"
          disabled={loading}
          className={`py-2 rounded text-white font-semibold transition ${
            loading
              ? "bg-gray-400 cursor-not-allowed"
              : "bg-blue-600 hover:bg-blue-700"
          }`}
        >
          {loading ? "Logging in..." : "Login"}
        </button>
      </form>
    </div>
  );
}

export default Login;
