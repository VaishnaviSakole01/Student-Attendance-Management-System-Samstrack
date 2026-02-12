import { Route, Routes } from "react-router-dom";

import AddStudent from "./assets/AddStudent";
import AddUser from "./assets/AddUser";
import AdminDashboard from "./assets/AdminDashboard";
import AllStudents from "./assets/AllStudents";
import AllSubject from "./assets/AllSubject";
import AllUser from "./assets/AllUser";
import FacultyDashboard from "./assets/FacultyDashboard";
import Footer from "./assets/Footer";
import Login from "./assets/Login";
import MarkAttendance from "./assets/MarkAttendance";
import Profile from "./assets/Profile";
import UpdateUser from "./assets/UpdateUser";
import ViewAttendance from "./assets/ViewAttendance";
import Welcome from "./assets/Welcome";

import "./App.css";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Welcome />} />
        <Route path="/login" element={<Login />} />

        <Route path="/admin-dashboard" element={<AdminDashboard />} />
        <Route path="/faculty-dashboard" element={<FacultyDashboard />} />

        <Route path="/add-user" element={<AddUser />} />
        <Route path="/all-users" element={<AllUser />} />
        <Route path="/update-user/:username" element={<UpdateUser />} />

        <Route path="/all-subject" element={<AllSubject />} />
        <Route path="/my-profile" element={<Profile />} />

        <Route path="/add-student" element={<AddStudent />} />
        <Route path="/all-students" element={<AllStudents />} />

        <Route path="/view-attendance" element={<ViewAttendance />} />
        <Route path="/mark-attendance" element={<MarkAttendance />} />
      </Routes>

      <Footer />
    </>
  );
}

export default App;
