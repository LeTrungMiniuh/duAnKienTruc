import React, { useState } from 'react';
import './Login.css';
import Register from './Register';

const Login = ({ onForgotPassword }) => {
    const [isRegisterOpen, setIsRegisterOpen] = useState(false);

    const [formData, setFormData] = useState({
        username: '',
        password: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Login data:', formData);
        alert('Đăng nhập với: ' + JSON.stringify(formData));
    };

    return (
        <div className="login-container">
            {isRegisterOpen ? (
                <Register /> // Nếu isRegisterOpen = true, hiển thị Register.js
            ) : (
                <div className="login-box">
                    <h2>Đăng nhập</h2>
                    <form onSubmit={handleSubmit}>
                        <div className="form-group">
                            <label>Tên đăng nhập</label>
                            <input
                                type="text"
                                name="username"
                                value={formData.username}
                                onChange={handleChange}
                                placeholder="Nhập tên đăng nhập"
                                required
                            />
                        </div>
                        <div className="form-group">
                            <label>Mật khẩu</label>
                            <input
                                type="password"
                                name="password"
                                value={formData.password}
                                onChange={handleChange}
                                placeholder="Nhập mật khẩu"
                                required
                            />
                        </div>
                        <button type="submit" className="login-button">
                            Đăng nhập
                        </button>
                    </form>
                    <div className="login-links">
                        <p onClick={onForgotPassword} className="link" style={{ cursor: 'pointer', color: 'blue' }}>
                            Quên mật khẩu?
                        </p>
                        <p 
                            onClick={() => setIsRegisterOpen(true)} 
                            className="link" 
                            style={{ cursor: 'pointer'}}
                        >
                            Đăng ký ngay
                        </p>
                        <a href="/dang-nhap-google" className="link google-link">
                            Đăng nhập bằng Google
                        </a>
                    </div>
                </div>
            )}
        </div>
    );
};

export default Login;
