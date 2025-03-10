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

  const handleSearch = (event) => {
    event.preventDefault();
    const searchQuery = event.target.search.value;
    console.log('Searching for:', searchQuery);
  };

  const handleLogoClick = () => {
    console.log('Logo clicked!');
  };

  const handleLoginClick = () => {
    setIsLoginOpen(true);
    setIsRegisterOpen(false);
    setIsForgotPasswordOpen(false);
  };

  const handleRegisterClick = () => {
    setIsRegisterOpen(true);
    setIsLoginOpen(false);
    setIsForgotPasswordOpen(false);
  };

  const handleForgotPasswordClick = () => {
    setIsForgotPasswordOpen(true);
    setIsLoginOpen(false);
    setIsRegisterOpen(false);
  };

  const handleCartClick = () => {
    console.log('Cart clicked!');
  };

  const handleCloseLogin = () => {
    setIsLoginOpen(false);
  };

  const handleCloseRegister = () => {
    setIsRegisterOpen(false);
  };

  const handleCloseForgotPassword = () => {
    setIsForgotPasswordOpen(false);
  };

  return (
    <div className="navbar-wrapper">
      <nav className="navbar">
        <div className="navbar-logo">
          <button className="logo-button" onClick={handleLogoClick}>
            <img src={logo} alt="SATO Logo" className="logo-image" />
          </button>
        </div>
        <ul className="navbar-links">
          <li><NavLink to="/ve-chung-toi" activeClassName="active">Về chúng tôi</NavLink></li>
          <li><NavLink to="/blog" activeClassName="active">Blog</NavLink></li>
          <li><NavLink to="/do-nam" activeClassName="active">Đồ nam</NavLink></li>
          <li><NavLink to="/do-nu" activeClassName="active">Đồ nữ</NavLink></li>
          <li><NavLink to="/tre-em" activeClassName="active">Trẻ em</NavLink></li>
          <li><NavLink to="/moi-noibat" activeClassName="active">Mới & Nổi bật</NavLink></li>
        </ul>
        <div className="navbar-search">
          <form onSubmit={handleSearch} className="search-form">
            <input
              type="text"
              name="search"
              placeholder="Tìm kiếm..."
              className="search-input"
            />
            <button type="submit" className="search-button">
              <FaSearch />
            </button>
          </form>
        </div>
        <div className="navbar-icons">
          <button className="icon-button" onClick={handleLoginClick}>
            <FaUser className="icon" /> Đăng nhập
          </button>
          <button className="icon-button" onClick={handleRegisterClick}>
            <FaLock className="icon" /> Đăng ký
          </button>
          <button className="icon-button" onClick={handleCartClick}>
            <FaShoppingCart className="icon" /> Giỏ hàng
          </button>
        </div>
      </nav>

      {/* Modal hiển thị component Login */}
      {isLoginOpen && (
        <div className="modal-overlay" onClick={handleCloseLogin}>
          <div className="modal" onClick={(e) => e.stopPropagation()}>
            <button className="close-button" onClick={handleCloseLogin}>×</button>
            <Login onForgotPassword={handleForgotPasswordClick} />
          </div>
        </div>
      )}

      {/* Modal hiển thị component Register */}
      {isRegisterOpen && (
        <div className="modal-overlay" onClick={handleCloseRegister}>
          <div className="modal" onClick={(e) => e.stopPropagation()}>
            <button className="close-button" onClick={handleCloseRegister}>×</button>
            <Register />
          </div>
        </div>
      )}

      {/* Modal hiển thị component Quên Mật Khẩu */}
      {isForgotPasswordOpen && (
        <div className="modal-overlay" onClick={handleCloseForgotPassword}>
          <div className="modal" onClick={(e) => e.stopPropagation()}>
            <button className="close-button" onClick={handleCloseForgotPassword}>×</button>
            <QuenMatKhau onBack={handleLoginClick} />
          </div>
        </div>
      )}
    </div>
  );
};

export default Navbar;
