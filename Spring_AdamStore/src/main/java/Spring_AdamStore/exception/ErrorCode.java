package Spring_AdamStore.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    UNCATEGORIZED_EXCEPTION(9999, "Lỗi hệ thống không xác định", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHENTICATED(1000, "Chưa xác thực người dùng", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1001, "Bạn chưa được phân quyền truy cập", HttpStatus.FORBIDDEN),
    USER_EXISTED(1002, "User đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1003, "Người dùng không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    INVALID_PASSWORD(1004, "Mật khẩu không chính xác", HttpStatus.UNAUTHORIZED),
    INVALID_OLD_PASSWORD(1024, "Mật khẩu cũ không chính xác", HttpStatus.BAD_REQUEST),
    INVALID_SORT_FIELD(1022, "Thuộc tính không hợp lệ để sắp xếp", HttpStatus.BAD_REQUEST),
    INVALID_SORT_FORMAT(1023, "Định dạng sortBy không hợp lệ phải là: field-asc hoặc field-desc", HttpStatus.BAD_REQUEST),
    EMAIL_SEND_FAILED(1017, "Lỗi khi gửi email", HttpStatus.BAD_REQUEST),
    EMAIL_EXISTED(1036, "Email đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    EMAIL_DISABLED(1037, "Email của bạn đã bị vô hiệu hóa", HttpStatus.FORBIDDEN),
    PHONE_EXISTED(1038, "Phone đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    PHONE_DISABLED(1039, "Phone của bạn đã bị vô hiệu hóa", HttpStatus.FORBIDDEN),
    USER_DISABLED(1039, "User đã bị vô hiệu hóa", HttpStatus.FORBIDDEN),
    TOKEN_TYPE_INVALID(1035, "Loại token không hợp lệ", HttpStatus.UNAUTHORIZED),
    INVALID_REFRESH_TOKEN(1034, "Refresh token không hợp lệ hoặc đã hết hạn", HttpStatus.UNAUTHORIZED),
    PROVINCE_EXISTED(1002, "Province đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    PROVINCE_NOT_EXISTED(1003, "Province không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    PRODUCT_EXISTED(1002, "Product đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_EXISTED(1003, "Product không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    CATEGORY_EXISTED(1002, "Category đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    CATEGORY_NOT_EXISTED(1003, "Category không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    BRANCH_EXISTED(1002, "Branch đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    BRANCH_NOT_EXISTED(1003, "Branch không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    VERIFICATION_CODE_NOT_FOUND(1018, "Mã xác minh không tồn tại", HttpStatus.NOT_FOUND),
    VERIFICATION_CODE_INVALID(1020, "Mã xác minh không đúng. Vui lòng thử lại.", HttpStatus.BAD_REQUEST),
    FORGOT_PASSWORD_TOKEN_NOT_FOUND(1025, "Token đặt lại mật khẩu không tồn tại hoặc đã hết hạn", HttpStatus.NOT_FOUND),
    VERIFICATION_CODE_EXPIRED(1019, "Mã xác nhận đã hết hạn", HttpStatus.BAD_REQUEST),
    ROLE_NOT_EXISTED(1014, "Role không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    PERMISSION_NOT_EXISTED(1016, "Permission không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    ORDER_ITEM_NOT_EXISTED(1003, "OrderItem không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    ORDER_NOT_EXISTED(1003, "Order không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    PROMOTION_EXISTED(1002, "Promotion đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    PROMOTION_NOT_EXISTED(1003, "Promotion không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    REVIEW_NOT_EXISTED(1003, "Review không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    DISTRICT_NOT_EXISTED(1003, "District không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    ADDRESS_NOT_EXISTED(1003, "Address không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    INVALID_PROVINCE_FOR_DISTRICT(1040, "District không thuộc Province đã chọn", HttpStatus.BAD_REQUEST),
    INVALID_DISTRICT_FOR_WARD(1040, "Ward không thuộc District đã chọn", HttpStatus.BAD_REQUEST),
    COLOR_EXISTED(1002, "Color đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    COLOR_NOT_EXISTED(1003, "Color không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    SIZE_EXISTED(1002, "Size đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    SIZE_NOT_EXISTED(1003, "Size không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    PASSWORD_MISMATCH(1041, "Mật khẩu nhập lại không khớp", HttpStatus.BAD_REQUEST),
    CART_ITEM_EXISTED(1002, "CartItem đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    CART_ITEM_NOT_EXISTED(1003, "CartItem không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    PRODUCT_VARIANT_EXISTED(1002, "ProductVariant đã tồn tại trong hệ thống", HttpStatus.BAD_REQUEST),
    PRODUCT_VARIANT_NOT_EXISTED(1003, "ProductVariant không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    OUT_OF_STOCK(1042, "Không đủ hàng trong kho", HttpStatus.BAD_REQUEST),
    INVALID_PRODUCT_IMAGE_LIST(2003, "Danh sách Ảnh không hợp lệ", HttpStatus.BAD_REQUEST),
    INVALID_PRODUCT_COLOR_LIST(2004, "Danh sách Màu không hợp lệ", HttpStatus.BAD_REQUEST),
    INVALID_PRODUCT_SIZE_LIST(2005, "Danh sách Size không hợp lệ", HttpStatus.BAD_REQUEST),
    CODE_TYPE_INVALID(1035, "Loại verificationCode không hợp lệ", HttpStatus.UNAUTHORIZED),
    PENDING_USER_NOT_FOUND(1043, "Không tìm thấy thông tin đăng ký", HttpStatus.NOT_FOUND),
    WARD_NOT_EXISTED(1003, "Ward không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    CART_NOT_EXISTED(1003, "Cart không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    PROMOTION_EXPIRED(1040, "Khuyến mãi đã hết hạn hoặc không hợp lệ", HttpStatus.BAD_REQUEST),
    ORDER_CANNOT_UPDATE_ADDRESS(2001, "Không thể cập nhật địa chỉ khi đơn hàng đã được giao hoặc huỷ", HttpStatus.BAD_REQUEST),
    ADDRESS_NOT_BELONG_TO_USER(1009, "Địa chỉ không thuộc về người dùng hiện tại", HttpStatus.FORBIDDEN),
    ORDER_NOT_BELONG_TO_USER(2002, "Đơn hàng không thuộc về người dùng hiện tại", HttpStatus.FORBIDDEN),
    PAYMENT_HISTORY_NOT_EXISTED(1003, "PaymentHistory không tồn tại trong hệ thống", HttpStatus.NOT_FOUND),
    INVALID_ORDER_STATUS(1100, "Đơn hàng không ở trạng thái PENDING", HttpStatus.FORBIDDEN),
    PROMOTION_ALREADY_USED(1038, "Bạn đã sử dụng mã khuyến mãi này rồi", HttpStatus.BAD_REQUEST),
    CATEGORY_DELETE_CONFLICT(1040, "Không thể xóa danh mục vì vẫn còn sản phẩm đang hoạt động", HttpStatus.CONFLICT),
    PROMOTION_USAGE_CONFLICT(1050, "Không thể xóa promotion này vì đã được sử dụng trong đơn hàng", HttpStatus.FORBIDDEN),
    USER_HAS_ACTIVE_PROMOTION_USAGE(1052, "Không thể xóa người dùng vì đã từng sử dụng khuyến mãi", HttpStatus.FORBIDDEN),
    USER_HAS_ACTIVE_ORDER(1053, "Người dùng có đơn hàng đang ở trạng thái Processing, Shipped hoặc Delivered", HttpStatus.FORBIDDEN),
    PRODUCT_VARIANT_USED_IN_ORDER(2001, "Không thể xóa mềm Product (Product Variant) vì đã được sử dụng trong đơn hàng.", HttpStatus.FORBIDDEN)

    ;



    private final int code;
    private final String message;
    private final HttpStatus statusCode;
}
