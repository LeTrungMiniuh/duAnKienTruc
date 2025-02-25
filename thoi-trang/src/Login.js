import Menu from "./comPoNent/Menu";
import logo from "../src/images/banner.jpg";
import './Login.css';
function login() {
    return (
        <div className="Login">
            <Menu />
            <div className="Login-Body">
                <div className="Login-Body-Banner">
                    <img src={logo} alt="Banner" />
                    <div className="Login-Form-Container">
                        <h2>Đăng nhập</h2>
                        <form className="Login-Form">
                            <div>
                                <label htmlFor="email">EMAIL:</label>
                                <input type="text" id="email" name="email" required />
                            </div>
                            <div>
                                <label htmlFor="password">MẬT KHẨU:</label>
                                <input type="password" id="password" name="password" required />
                            </div>
                            <button type="submit">Đăng nhập</button>
                            <div className="forgotpass">
                                <a href="/login">Quên mật khẩu?</a>
                            </div>
                            <div className="dont-have-pass">
                                <p>Bạn chưa có tài khoản? <a href="/login">Đăng ký ngay</a></p>
                            </div>
                            <div>
                                <button>Đăng Nhập bằng Google</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default login;