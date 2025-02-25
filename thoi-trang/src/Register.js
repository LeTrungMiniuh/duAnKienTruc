import Menu from "./comPoNent/Menu";
import logo from "../src/images/banner.jpg";
import './Register.css';

function Register() {
    return (
        <div className="Register">
            <Menu />
            <div className="Register-Body">
                <div className="Register-Body-Banner">
                    <img src={logo} alt="Banner" />
                    <div className="Register-Form-Container">
                        <h2>Đăng Ký</h2>
                        <form className="Register-Form">
                            <div>
                                <label htmlFor="fullName">Họ Tên:</label>
                                <input type="text" id="fullName" name="fullName" required />
                            </div>
                            <div>
                                <label htmlFor="phone">Số Điện Thoại:</label>
                                <input type="tel" id="phone" name="phone" required />
                            </div>
                            <div>
                                <label htmlFor="email">Địa Chỉ Email:</label>
                                <input type="email" id="email" name="email" required />
                            </div>
                            <div>
                                <label htmlFor="password">Mật Khẩu:</label>
                                <input type="password" id="password" name="password" required />
                            </div>
                            <div>
                                <label htmlFor="confirmPassword">Xác Nhận Mật Khẩu:</label>
                                <input type="password" id="confirmPassword" name="confirmPassword" required />
                            </div>
                            <button type="submit">Đăng Ký</button>
                        </form>
                        <div className="Register-Links">
                            <p>Đã có tài khoản? <a href="/login">Đăng nhập ngay</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Register;