import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function AdminMenu() {
  const [userMenuOpen, setUserMenuOpen] = useState(false);
  const navigate = useNavigate();

  const logout = () => {
    localStorage.removeItem("role");
    localStorage.removeItem("username");
    navigate("/");
  };

  return (
    <div className="bg-gray-50">
      <nav className="bg-white shadow flex items-center justify-between px-6 py-4">
        {/* Brand */}
        <div className="text-lg font-bold text-blue-600">SAMSTRACK</div>

        {/* Center Menu */}
        <div className="flex items-center gap-3">
          <Link
            to="/admin-dashboard"
            className="font-semibold text-blue-600 px-3 py-2 rounded hover:bg-blue-50 transition"
          >
            Dashboard
          </Link>

          {/* User Dropdown */}
          <div className="relative">
            <button
              className="font-semibold text-blue-600 px-3 py-2 rounded hover:bg-blue-50 transition flex items-center gap-1"
              onClick={() => setUserMenuOpen(!userMenuOpen)}
            >
              User <span>▼</span>
            </button>

            {userMenuOpen && (
              <div className="absolute left-0 mt-2 w-40 bg-white border rounded shadow-lg z-10">
                <Link
                  to="/add-user"
                  className="block px-4 py-2 hover:bg-blue-100 transition"
                >
                  Add User
                </Link>
                <Link
                  to="/all-users"
                  className="block px-4 py-2 hover:bg-blue-100 transition"
                >
                  All User
                </Link>
              </div>
            )}
          </div>

          <Link
            to="/all-subject"
            className="font-semibold text-blue-600 px-3 py-2 rounded hover:bg-blue-50 transition"
          >
            All Subject
          </Link>

          <Link
            to="/view-attendance"
            className="font-semibold text-blue-600 px-3 py-2 rounded hover:bg-blue-50 transition"
          >
            View Attendance
          </Link>
        </div>

        {/* Right Menu */}
        <div className="flex items-center gap-4">
          <Link
            to="/my-profile"
            className="font-semibold text-gray-700 px-3 py-2 rounded hover:bg-gray-100 transition"
          >
            MyProfile
          </Link>

          <button
            onClick={logout}
            className="bg-red-500 text-white px-3 py-2 rounded hover:bg-red-600 transition"
          >
            Logout
          </button>
        </div>
      </nav>
    </div>
  );
}

export default AdminMenu;
