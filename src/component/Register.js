import React, { useState } from 'react';
import './Register.css'; // File CSS riêng

const Register = () => {
    const [formData, setFormData] = useState({
        fullName: '',
        phoneNumber: '',
        email: '',
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
        console.log('Register data:', formData); // Logic đăng ký thực tế (gọi API, kiểm tra, v.v.) có thể được thêm vào đây
        alert('Đăng ký với: ' + JSON.stringify(formData));
    };

    return (
        <div className="register-container">
            <div className="register-box">
                <h2>Đăng Ký</h2>
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label>Họ tên</label>
                        <input
                            type="text"
                            name="fullName"
                            value={formData.fullName}
                            onChange={handleChange}
                            placeholder="Nhập họ tên"
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Số điện thoại</label>
                        <input
                            type="tel"
                            name="phoneNumber"
                            value={formData.phoneNumber}
                            onChange={handleChange}
                            placeholder="Nhập số điện thoại"
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Địa chỉ email</label>
                        <input
                            type="email"
                            name="email"
                            value={formData.email}
                            onChange={handleChange}
                            placeholder="Nhập địa chỉ email"
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
                    <button type="submit" className="register-button">
                        Đăng ký
                    </button>
                </form>
                <div className="register-links">
                    <a href="/dang-nhap" className="link">
                        Bạn đã có tài khoản? Đăng nhập ngay
                    </a>
                </div>
            </div>
        </div>
    );
};

export default Register;