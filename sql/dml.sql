INSERT INTO [user] (deleted, status, created_at, password, username) VALUES (0, 1, N'2024-04-12 02:26:59.660000', N'$2a$10$q39wz54zjT9Qvc72N8ReHOqbbZVzAxkxl43ZgVacBzbQOJeL5TYt6', N'anhdt');
INSERT INTO [user] (deleted, status, created_at, password, username) VALUES (0, 1, N'2024-04-12 02:26:59.660000', N'$2a$10$9UsGzpJaXEvo3RgYvIWp1OnbpvYMD6mEeL270KvUX9LIIiCj9qeaS', N'minhth');


INSERT INTO user_detail (user_id, gender, dob, mobile, email) VALUES (1, 1, N'11/11/1994', N'0987777888', N'anhdt@gmail.com');
INSERT INTO user_detail (user_id, gender, dob, mobile, email) VALUES (1, 1, N'18/10/2001', N'0936734833', N'minhth@gmail.com');


INSERT INTO role (role_name) VALUES (N'ROLE_ADMIN');
INSERT INTO role (role_name) VALUES (N'ROLE_EMPLOYEE');
INSERT INTO role (role_name) VALUES (N'ROLE_MEMBER');


INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (1, 3);
INSERT INTO user_role (user_id, role_id) VALUES (2, 3);


INSERT INTO brand (brand_name) VALUES (N'Chanel');
INSERT INTO brand (brand_name) VALUES (N'Dior');
INSERT INTO brand (brand_name) VALUES (N'Gucci');
INSERT INTO brand (brand_name) VALUES (N'YSL');
INSERT INTO brand (brand_name) VALUES (N'Louboutin');


INSERT INTO category (category_name) VALUES (N'Son Thỏi');
INSERT INTO category (category_name) VALUES (N'Son Kem');
INSERT INTO category (category_name) VALUES (N'Son Dưỡng');


INSERT INTO product (product_name, product_image, product_price, product_quantity, product_short_description, category_id, brand_id) VALUES (N'Son YSL Rouge Pur Couture Caring Satin Lipstick RM Rouge Muse – Màu Đỏ Ruby', N'son-ysl-rouge-pur-couture-caring-satin-lipstick-rm-rouge-muse-4.jpg', N'850000', 10, N'Nếu nàng đang tìm kiếm cho bản thân một thỏi son có tông màu đỏ để tự tin hơn mỗi khi xuất hiện trước đám đông thì Son YSL Rouge Pur Couture Caring Satin Lipstick RM Rouge Muse – Màu Đỏ Ruby là thỏi son mà nàng không thể nào bỏ lỡ. Màu son đỏ ruby quốc dân chuẩn quý cô cùng chất son giàu dưỡng giúp chăm sóc đôi môi từ sâu bên trong đã khiến YSL RM trở thành thỏi son bán chạy nhất hiện tại.', 1, 4);
INSERT INTO product (product_name, product_image, product_price, product_quantity, product_short_description, category_id, brand_id) VALUES (N'Son Dưỡng Chanel Rouge Coco Baume 912 Dreamy White – Không Màu', N'son-duong-chanel-rouge-coco-baume-912-dreamy-white-1.jpg', N'1450000', 10, N'Không chỉ những thỏi son có màu sắc lòe loẹt mới tỏa sáng trong thế giới son môi mà đôi khi sự đơn giản cũng có thể làm ai đó phải siêu lòng. Son Dưỡng Chanel Rouge Coco Baume 912 Dreamy White – Không Màu chính là một sản phẩm như thế, vì mang màu son trong suốt nên tập trung hoàn toàn vào chất son siêu dưỡng, giúp đôi môi nàng luôn mềm mịn và căng mọng.', 3, 1);
INSERT INTO product (product_name, product_image, product_price, product_quantity, product_short_description, category_id, brand_id) VALUES (N'Son Chanel Rouge Coco Flash Hydrating Vibrant Shine Lip Colour 148 Lively – Màu Đỏ Cherry', N'son-chanel-rouge-coco-flash-hydrating-vibrant-shine-lip-colour-148-lively-8.jpg', N'1050000', 10, N'Son Chanel Rouge Coco Flash Hydrating Vibrant Shine Lip Colour 148 Lively – Màu Đỏ Cherry ngọt ngào, sang chảnh và cũng thật quyến rũ. Cho dù nàng đang theo đuổi phong cách nào thì em  Chanel 148 Lively này cũng dễ dàng giúp bạn cộng điểm trong mắt đối phương.', 1, 1);
INSERT INTO product (product_name, product_image, product_price, product_quantity, product_short_description, category_id, brand_id) VALUES (N'Son Dưỡng Dior Addict Lip Maximizer 009 Intense Rosewood – Màu Hồng Đất', N'son-duong-dior-addict-lip-maximizer-009-intense-rosewood-40.jpg', N'850000', 10, N'Son Dưỡng Dior Addict Lip Maximizer 009 Intense Rosewood – Màu Hồng Đất là thỏi son dưỡng cao cấp của thương hiệu Dior, sở hữu chức năng kép vừa làm đẹp cho đôi môi với màu hồng đất quyến rũ, vừa có khả năng chăm sóc đôi môi từ sâu bên trong khiến các tín đồ mê làm đẹp săn đón ngay từ khi mới ra mắt.', 3, 2);
INSERT INTO product (product_name, product_image, product_price, product_quantity, product_short_description, category_id, brand_id) VALUES (N'Son Dior Rouge Dior Satin Lipstick 999 – Màu Đỏ Tươi', N'son-dior-rouge-dior-satin-lipstick-999.png', N'990000', 10, N'Son Dior Rouge Dior Satin Lipstick 999 – Màu Đỏ Tươi là thỏi son mà bất cứ cô gái nào mê son đỏ cũng không thể bỏ qua. Màu son đỏ tươi giúp nàng trở nên thanh lịch, quyến rũ như những quý cô kiêu kỳ. Chất son mềm mại của Dior 999 này càng khiến nàng mê mẩn ngay từ lần thoa son đầu tiên.', 1, 2);
INSERT INTO product (product_name, product_image, product_price, product_quantity, product_short_description, category_id, brand_id) VALUES (N'Son Gucci Rouge À Lèvres Voile 508 Diana Amber (Vỏ Hoa) – Màu Đỏ Ruby', N'son-gucci-rouge-a-levres-voile-508-diana-amber-vo-hoa-mau-do-ruby-6.jpg', N'1050000', 10, N'Son Gucci Rouge À Lèvres Voile 508 Diana Amber (Vỏ Hoa) – Màu Đỏ Ruby là biểu tượng của sự sang trọng và quý phái. Thiết kế vỏ hoa độc đáo, kết hợp với gam màu đỏ ruby sâu lắng, tạo nên một sự hòa quyện tinh tế và đẳng cấp. Với chất son mềm mịn và dưỡng ẩm, cây son này mang lại vẻ đẹp quyến rũ và tự tin cho bất kỳ ai.', 1, 3);
INSERT INTO product (product_name, product_image, product_price, product_quantity, product_short_description, category_id, brand_id) VALUES (N'Son Gucci Rouge À Lèvres Mat Lipstick Limited 509 Janie Scarlet Xmas – Màu Đỏ Trầm', N'son-gucci-rouge-a-levres-mat-lipstick-limited-509-janie-scarlet-xmas-11.jpg', N'1050000', 10, N'Son Gucci Rouge À Lèvres Mat Lipstick Limited 509 Janie Scarlet Xmas – Màu Đỏ Trầm là thỏi son có màu sắc chuẩn mùa lễ hội cuối năm được thương hiệu Gucci cho ra mắt nhân dịp lễ giáng sinh. Với gam màu đỏ trầm thời thượng, Gucci 509 Scarlet Xmas đã làm tan chảy mọi trái tim của các cô gái ngay từ khi mới ra mắt. Thỏi son lên môi căng mọng, quyến rũ với chất son giàu dưỡng, mềm mịn đáng ngưỡng mộ.', 1, 3);
INSERT INTO product (product_name, product_image, product_price, product_quantity, product_short_description, category_id, brand_id) VALUES (N'Son Kem Lì Gucci Rouge Liquid Matte 521 Nellie Cherrie (New) – Màu Đỏ Gạch', N'son-kem-li-gucci-rouge-liquid-matte-521-nellie-cherrie-2.jpg', N'980000', 10, N'Son Kem Lì Gucci Rouge Liquid Matte 521 Nellie Cherrie – Màu Đỏ Gạch là một lựa chọn màu son mạnh mẽ và quyến rũ, tạo nên một vẻ đẹp nổi bật và phong cách. Sắc son Gucci 521 đỏ gạch là sự kết hợp độc đáo của đỏ rực rỡ và chút tone màu đất, tạo ra một màu sắc lôi cuốn và ấn tượng.', 2, 3);
INSERT INTO product (product_name, product_image, product_price, product_quantity, product_short_description, category_id, brand_id) VALUES (N'Son Christian Louboutin Lipstick Sillky Satin Brick Chick 515 (Mới Nhất) – Màu Đỏ Gạch', N'son-christian-louboutin-lipstick-sillky-satin-brick-chick-515-dd.jpg', N'2850000', 5, N'Nếu bạn là cô nàng cá tính muốn tìm lại vẻ đẹp truyền thống hoặc cô nàng truyền thống muốn trải nghiệm phong cách mới thì Son Christian Louboutin Lipstick Silky Satin Brick Chick 515 – Màu Đỏ Gạch vừa mới ra mắt của thương hiệu Christian Louboutin chắc chắn sẽ là sự lựa chọn hoàn hảo. Màu son đỏ gạch phù hợp với nhiều phong cách trang phục và phối màu trang điểm khác nhau, mang đến cho các quý cô một vẻ đẹp vừa truyền thống vừa hiện đại.', 1, 5);
INSERT INTO product (product_name, product_image, product_price, product_quantity, product_short_description, category_id, brand_id) VALUES (N'Son Christian Louboutin Velvet Matte Epic Brunette 318M (Mới Nhất) – Màu Đỏ Gạch', N'son-christian-louboutin-velvet-matte-epic-brunette-318m-moi-nhat-mau-do-gach-dd.jpg', N'3200000', 5, N'Son Christian Louboutin Velvet Matte Epic Brunette 318M – Màu Đỏ Gạch, một sắc đỏ đầy quyến rũ và mạnh mẽ. Sắc đỏ này không chỉ là biểu tượng của vẻ đẹp thanh lịch mà còn thể hiện sự tự tin và phong thái riêng của người phụ nữ hiện đại.', 1, 5);

INSERT INTO product (product_name, product_color, product_image, product_price, product_quantity, product_short_description, category_id, brand_id) VALUES (N'Son YSL Slim Velvet 21 Rouge Paradoxe', N'Màu Đỏ Ruby', N'son-ysl-slim-velvet-21-rouge-paradox.png', N'950000', 10, N'Son YSL Slim Velvet 21 Rouge Paradoxe – Màu Đỏ Ruby ra đời đã khiến nhiều tín đồ mê làm đẹp nhanh tay đặt hàng bởi màu son đỏ ruby thời thượng cùng chất son lì với kết cấu mềm mại như nhung mịn màng khiến nàng thích thú.', 1, 4);

