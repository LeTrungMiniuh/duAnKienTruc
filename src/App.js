import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
// import NavBar from '../src/component/Navbar'; // Thêm ./ vào trước
import Login from './component/Login'; // Thêm ./ vào trước
import QuenMatKhau from './component/QuenMatKhau'; // Thêm ./ vào trước
import Register from './component/Register'; // Thêm ./ vào trước
import HomePage from './page/HomePage'; // Thêm ./ vào trước

function App() {
    return (
        <Router>
            <div>
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path="/dang-nhap" element={<Login />} />
                    <Route path="/quen-mat-khau" element={<QuenMatKhau onBack={() => window.history.back()} />} />
                    <Route path="/dang-ky" element={<Register />} />
                    <Route path="/dang-nhap-google" element={<div>Đăng nhập bằng Google (Chưa triển khai)</div>} />
                    <Route path="/ve-chung-toi" element={<div>Về chúng tôi</div>} />
                    <Route path="/blog" element={<div>Blog</div>} />
                    <Route path="/do-nam" element={<div>Đồ nam</div>} />
                    <Route path="/do-nu" element={<div>Đồ nữ</div>} />
                    <Route path="/tre-em" element={<div>Trẻ em</div>} />
                    <Route path="/moi-noibat" element={<div>Mới & Nổi bật</div>} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;