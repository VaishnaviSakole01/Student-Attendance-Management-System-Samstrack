import { Link } from "react-router-dom";
import AdminMenu from "./AdminMenu";

const adminFunctions = [
  {
    title: "Add User",
    description: "Create a new user account",
    path: "/add-user",
    icon: "👤",
  },
  {
    title: "All Users",
    description: "View and manage all users",
    path: "/all-users",
    icon: "👥",
  },
  {
    title: "All Subjects",
    description: "View subjects",
    path: "/all-subject",
    icon: "📚",
  },
  {
    title: "View Attendance",
    description: "Check attendance",
    path: "/view-attendance",
    icon: "📊",
  },
];

function AdminDashboard() {
  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-200 via-purple-200 to-pink-200">
      <AdminMenu />

      <div className="max-w-6xl mx-auto py-12 px-4">
        <h2 className="text-2xl font-bold text-center mb-8">
          Admin Functionalities
        </h2>

        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
          {adminFunctions.map((func, index) => (
            <Link
              to={func.path}
              key={index}
              className="bg-white p-6 rounded shadow hover:shadow-lg transition text-center"
            >
              <div className="text-4xl">{func.icon}</div>
              <h3 className="font-bold mt-3">{func.title}</h3>
              <p className="text-sm text-gray-600">{func.description}</p>
            </Link>
          ))}
        </div>
      </div>
    </div>
  );
}

export default AdminDashboard;
