import React, { useState } from 'react';
import { NavLink } from 'react-router-dom';
import { FaUser, FaLock, FaShoppingCart, FaSearch } from 'react-icons/fa';
import logo from '../asssets/logo.png';
import './Navbar.css';
import Login from './Login';
import Register from './Register';
import QuenMatKhau from './QuenMatKhau';

const Navbar = () => {
  const [isLoginOpen, setIsLoginOpen] = useState(false);
  const [isRegisterOpen, setIsRegisterOpen] = useState(false);
  const [isForgotPasswordOpen, setIsForgotPasswordOpen] = useState(false);
  const [isAboutUsOpen, setIsAboutUs] = useState(false);
  const handleSearch = (event) => {
    event.preventDefault();
    const searchQuery = event.target.search.value;
    console.log('Searching for:', searchQuery);
  };
  return (
    <div className="navbar-wrapper">
      <nav className="navbar">
        <div className="navbar-logo">
          <NavLink to="/">
            <img src={logo} alt="SATO Logo" className="logo-image" />
          </NavLink>
        </div>
        <ul className="navbar-links">
          <li>
            <NavLink to="/about-us" className={({ isActive }) => (isActive ? "active" : "")}>
              Về chúng tôi
            </NavLink>
          </li>
          <li>
            <NavLink to="/blog" className={({ isActive }) => (isActive ? "active" : "")}>
              Blog
            </NavLink>
          </li>
          <li>
            <NavLink to="/do-nam" className={({ isActive }) => (isActive ? "active" : "")}>
              Đồ nam
            </NavLink>
          </li>
          <li>
            <NavLink to="/do-nu" className={({ isActive }) => (isActive ? "active" : "")}>
              Đồ nữ
            </NavLink>
          </li>
          <li>
            <NavLink to="/tre-em" className={({ isActive }) => (isActive ? "active" : "")}>
              Trẻ em
            </NavLink>
          </li>
          <li>
            <NavLink to="/moi-noibat" className={({ isActive }) => (isActive ? "active" : "")}>
              Mới & Nổi bật
            </NavLink>
          </li>
        </ul>
        <div className="navbar-search">
          <form onSubmit={handleSearch} className="search-form">
            <input type="text" name="search" placeholder="Tìm kiếm..." className="search-input" />
            <button type="submit" className="search-button">
              <FaSearch />
            </button>
          </form>
        </div>
        <div className="navbar-icons">
          <button className="icon-button" onClick={() => setIsLoginOpen(true)}>
            <FaUser className="icon" /> Đăng nhập
          </button>
          <button className="icon-button" onClick={() => setIsRegisterOpen(true)}>
            <FaLock className="icon" /> Đăng ký
          </button>
          <button className="icon-button">
            <FaShoppingCart className="icon" /> Giỏ hàng
          </button>
        </div>
      </nav>

      {/* Modal hiển thị component Login */}
      {isLoginOpen && (
        <div className="modal-overlay" onClick={() => setIsLoginOpen(false)}>
          <div className="modal" onClick={(e) => e.stopPropagation()}>
            <button className="close-button" onClick={() => setIsLoginOpen(false)}>×</button>
            <Login onForgotPassword={() => setIsForgotPasswordOpen(true)} />
          </div>
        </div>
      )}

      {/* Modal hiển thị component Register */}
      {isRegisterOpen && (
        <div className="modal-overlay" onClick={() => setIsRegisterOpen(false)}>
          <div className="modal" onClick={(e) => e.stopPropagation()}>
            <button className="close-button" onClick={() => setIsRegisterOpen(false)}>×</button>
            <Register />
          </div>
        </div>
      )}

      {/* Modal hiển thị component Quên Mật Khẩu */}
      {isForgotPasswordOpen && (
        <div className="modal-overlay" onClick={() => setIsForgotPasswordOpen(false)}>
          <div className="modal" onClick={(e) => e.stopPropagation()}>
            <button className="close-button" onClick={() => setIsForgotPasswordOpen(false)}>×</button>
            <QuenMatKhau onBack={() => setIsLoginOpen(true)} />
          </div>
        </div>
      )}
    </div>
  );
};

export default Navbar;
