import React from 'react';
import Navbar from '../component/Navbar';
import './HomePage.css';

const HomePage = () => {
  return (
    <div className="homepage-wrapper">
      <Navbar />
      
      {/* Danh mục nổi bật */}
      <div className="featured-categories">
        <h2>DANH MỤC NỔI BẬT</h2>
        <div className="categories-container">
          <div className="category-box">Đồ nam</div>
          <div className="category-box">Áo thun nam</div>
          <div className="category-box">Áo hoodie nam</div>
          <div className="category-box">Đồ nữ</div>
        </div>
      </div>
      
      {/* Bộ lọc */}
      <div className="product-section">
        <div className="filter-section">
          <h3>Chọn khoảng giá</h3>
          <input type="number" placeholder="Từ" /> - <input type="number" placeholder="Đến" />
          <button>Áp dụng</button>
          
          <h3>Chọn danh mục</h3>
          <label><input type="checkbox" /> Đồ nam</label>
          <label><input type="checkbox" /> Đồ nữ</label>
          <label><input type="checkbox" /> Trẻ em</label>
        </div>
        
        {/* Danh sách sản phẩm */}
        <div className="product-list">
          <h3>Có 5 sản phẩm được tìm thấy</h3>
          <div className="products">
            <div className="product-item">Sản phẩm 1</div>
            <div className="product-item">Sản phẩm 2</div>
            <div className="product-item">Sản phẩm 3</div>
            <div className="product-item">Sản phẩm 4</div>
            <div className="product-item">Sản phẩm 5</div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default HomePage;
