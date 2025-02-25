import logo from './logo.jpg'; 
import { FaSearch, FaShoppingCart } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import './Menu.css';

const Menu = () => {
    const handleRegisterClick = () => {
        // You can add any logic here if needed
        // The previous <link rel="stylesheet"> was invalid in this context
        // If you need to dynamically add a stylesheet, you'd need a different approach
    };

    return (
        <nav className="menu">
            <ul className="menu-list">
                <li className="menu-item">
                    <Link to="/home" className="logo-link">
                        <img src={logo} alt="Logo" />
                    </Link>
                </li>
                <li className="menu-item">
                    <Link to="/about-us">Về chúng tôi</Link>
                </li>
                <li className="menu-item">
                    <Link to="/blog">Blog</Link>
                </li>
                <li className="menu-item">
                    <Link to="/men">Đồ nam</Link>
                </li>
                <li className="menu-item">
                    <Link to="/women">Đồ nữ</Link>
                </li>
                <li className="menu-item">
                    <Link to="/kids">Trẻ em</Link>
                </li>
                <li className="menu-item">
                    <Link to="/new-arrivals">Hàng mới về</Link>
                </li>
                <li className="menu-item search">
                    <div className="search-wrapper">
                        <input type="text" placeholder="Tìm kiếm..." />
                        <button className="search-button">
                            <FaSearch className="search-icon" />
                        </button>
                    </div>
                </li>
                <li className="menu-item">
                    <button className="auth-button">
                        <Link to="/login" style={{ color: 'white', textDecoration: 'none' }}>
                            Đăng nhập
                        </Link>
                    </button>
                </li>
                <li className="menu-item">
                    <button className="auth-button" onClick={handleRegisterClick}>
                        <Link to="/register" style={{ color: 'white', textDecoration: 'none' }}>
                            Đăng ký
                        </Link>
                    </button>
                </li>
                <li className="menu-item">
                    <button className="cart-button">
                        <FaShoppingCart className="cart-icon" />
                        <Link to="/cart" style={{ color: 'white', textDecoration: 'none', marginLeft: '5px' }}>
                            Giỏ hàng
                        </Link>
                    </button>
                </li>
            </ul>
        </nav>
    );
};

export default Menu;