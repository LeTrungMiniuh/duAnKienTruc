import React, { useState } from 'react';
import './QuenMatKhau.css';

const QuenMatKhau = ({ onBack }) => {
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    setMessage('Nếu email tồn tại, chúng tôi đã gửi hướng dẫn khôi phục mật khẩu.');
  };

  return (
    <div className="quenmatkhau-container">
      <div className="quenmatkhau-box">
        <h2 className="title">
          <span className="blue-text">QUÊN</span> <span className="orange-text">MẬT KHẨU</span>
        </h2>
        <p className="description">
          Nếu bạn quên mật khẩu, vui lòng nhập địa chỉ email đã đăng ký của bạn. 
          Chúng tôi sẽ gửi cho bạn một liên kết để đặt lại mật khẩu.
        </p>
        <form onSubmit={handleSubmit}>
          <input
            type="email"
            placeholder="Nhập email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            className="input-field"
          />
          <div className="button-group">
            <button type="button" className="cancel-btn" onClick={onBack}>HỦY</button>
            <button type="submit" className="submit-btn">TIẾP TỤC</button>
          </div>
        </form>
        {message && <p className="success-message">{message}</p>}
      </div>
    </div>
  );
};

export default QuenMatKhau;
