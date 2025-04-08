import React, { useState } from 'react';
import { Link, useLocation } from 'react-router-dom';
import './Login.css';

const Login = () => {
    const [formData, setFormData] = useState({
        username: '',
        password: '',
    });

    const location = useLocation();

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

    const getLinkClassName = (path) => {
        return location.pathname === path ? 'link active' : 'link';
    };

    return (
        <div className="login-container">
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
                    <Link to="/quen-mat-khau" className={getLinkClassName('/quen-mat-khau')}>
                        Quên mật khẩu?
                    </Link>
                    <Link to="/dang-ky" className={getLinkClassName('/dang-ky')}>
                        Đăng ký ngay
                    </Link>
                    <Link to="/dang-nhap-google" className={getLinkClassName('/dang-nhap-google')}>
                        Đăng nhập bằng Google
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default Login;