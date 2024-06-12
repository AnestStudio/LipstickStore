INSERT INTO role (role_name) VALUES (N'ROLE_ADMIN');
INSERT INTO role (role_name) VALUES (N'ROLE_EMPLOYEE');
INSERT INTO role (role_name) VALUES (N'ROLE_MEMBER');


INSERT INTO [user] (username, password, full_name, created_at, status, deleted) VALUES (N'anhdt', N'$2a$10$q39wz54zjT9Qvc72N8ReHOqbbZVzAxkxl43ZgVacBzbQOJeL5TYt6', N'Đinh Tuấn Anh', N'2024-04-12 02:26:59.660000', 1, 0);
INSERT INTO [user] (username, password, full_name, created_at, status, deleted) VALUES (N'minhth', N'$2a$10$9UsGzpJaXEvo3RgYvIWp1OnbpvYMD6mEeL270KvUX9LIIiCj9qeaS', N'Trần Hoàng Minh', N'2024-04-12 02:26:59.660000', 1, 0);


INSERT INTO user_detail (user_id, gender, dob, mobile, email) VALUES (1, 1, N'11/11/1994', N'0987777888', N'anhdt@gmail.com');
INSERT INTO user_detail (user_id, gender, dob, mobile, email) VALUES (2, 1, N'18/10/2001', N'0936734833', N'minhth@gmail.com');


INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (1, 3);
INSERT INTO user_role (user_id, role_id) VALUES (2, 3);


INSERT INTO user_address (user_id, receiver_name, receiver_mobile, user_address_detail, user_address_wards, user_address_districts, user_address_provinces, default_address) VALUES (2, N'Trần Hoàng Minh', N'0977657876', N'Fville 3, Fpt Software, Khu Công Nghệ Cao Hoà Lạc', N'Xã Tân Xã', N'Huyện Thạch Thất', N'Hà Nội', 1);


INSERT INTO brand (brand_name, brand_description) VALUES (N'Chanel', N'<p><span class="fw-medium">Thương hiệu Chanel</span> là một thương hiệu được thành lập từ những năm 1909 – 1910 do Gabrielle “Coco” Chanel sáng lập. Chanel là một thương hiệu thời trang, mỹ phẩm cao cấp hàng đầu nước Pháp, mang trọn vẹn những tinh hoa, nét đẹp của đất nước này.</p>
<p>Nhắc tới Chanel là nhắc tới thương hiệu thời trang, mỹ phẩm đẳng cấp có tiếng trong giới. <span class="fw-medium">Son Chanel</span> nói riêng và mỹ phẩm Chanel nói chung đều là những sản phẩm chất lượng và giá thành tương xứng.</p>');
INSERT INTO brand (brand_name, brand_description) VALUES (N'Dior', N'<p><span class="fw-medium">Dior</span> là một thương của Pháp thành lập vào năm 1946 bởi Christian Dior thuộc kiểm soát của LVMH cùng một công ty với Fendi. Ngoài mảng chủ đạo là thời thì hãng còn nổi tiếng về các dòng mỹ phẩm. Mỹ phẩm của Dior được biết đến với chất lượng đi đôi cùng với vẻ ngoài sang trọng, nhã nhặn.</p>
<p>Khi nhắc đến son Dior người ta nhắc đến vẻ ngoài sang trọng cùng với chất lượng tuyệt vời mà nó mang lại với 4 dòng son môi: Dior Addict, Dior Addict Lip Glow, Dior Rouge và Diorific.</p>
<p>Những thỏi son của Dior được nhiều người lựa chọn cũng bởi chính chất lượng tuyệt vời của chúng. Trước hết là ở thiết kế vô cùng đẳng cấp. Khác biệt của Dior với những dòng son môi khác cùng phân khúc high-end như YSL, Chanel...</p>');
INSERT INTO brand (brand_name, brand_description) VALUES (N'Gucci', N'<p><span class="fw-medium">Thương hiệu Gucci</span>  được thành lập từ năm 1921,Gucci là một thương hiệu thời trang Ý. Tiếp nối thành công với các sản phẩm thời trang, Gucci cho ra đời các sản phẩm mỹ phẩm cao cấp dành cho giới thượng lưu.</p>
<p>Son Gucci xuất hiện trên thị trường một lần nữa đã khẳng định đẳng cấp là một trong những thương hiệu đắt giá nhất thế giới. Gucci không chỉ thành công trong mảng thời trang mà còn gây tiếng vang lớn với các sản phẩm mỹ phẩm, đặc biệt là son. Son Gucci là dòng sản phẩm mà từ các tiểu thư, sao hạng A đều săn đón và trở thành món đồ không thể thiếu. Với hơn 60 màu son trong bảng màu son Gucci đã chinh phục được mọi trái tim các cô gái.</p>');
INSERT INTO brand (brand_name, brand_description) VALUES (N'YSL', N'<p><span class="fw-medium">YSL</span> là tên viết tắt của thương hiệu <span class="fw-medium">Yves Saint Laurent</span>, một thương hiệu về thời trang và mỹ phẩm cao cấp nổi tiếng đến từ Pháp, được thành lập vào năm 1961 bởi nhà thiết kế Yves Saint Laurent và Pierre Bergé.</p>
<p>Đến nay, YSL vẫn là một thương hiệu dẫn đầu tạo ra xu hướng hiện đại, sang trọng, thanh lịch. Bên canh đó, thương hiệu còn mở rộng sang các thị trường khác như giày dép, túi xách, phụ kiện thời trang... và luôn được đông đảo mọi người ủng hộ.</p>');
INSERT INTO brand (brand_name, brand_description) VALUES (N'Louboutin', N'<p><span class="fw-medium">Son Christian Louboutin</span> là thỏi son đáng mơ ước của mọi cô gái, chúng được ví như những món trang sức thần kỳ “hô biến” nhan sắc của bạn trở nên lộng lẫy và kiêu sa; bởi vậy dù có mức giá khá đắt nhưng son Louboutin vẫn khiến các nàng phải mê mệt và mơ ước được sở hữu thỏi son này. </p>
<p>Louboutin được thành lập bởi nhà thiết kế tài ba cùng tên người Pháp, Nhà thiết kế tài ba cùng tên người Pháp, Christian Louboutin đã làm nên cuộc cách mạng tuyệt vời cho phái đẹp bằng những đôi giày đế đỏ vào thế kỷ 20. Đó cũng là lý do đến tận hôm nay, thương hiệu này vẫn được gọi với cái tên đầy kiêu hãnh – “Giày đế đỏ”.</p>
<p>Từ năm 2015 đến nay, thương hiệu này liên tục cho ra mắt các dòng son với thiết kế độc đáo. Trong đó có không ít dòng son đã đi vào lịch sử ngành mỹ phẩm như một hiện tượng, tạo sức hấp dẫn đến từ Christian Louboutin mà không ai có thể xem thường.</p>');
INSERT INTO brand (brand_name, brand_description) VALUES (N'MAC', N'<p><span class="fw-medium">Son MAC</span> là dòng son cao cấp, được các chuyên gia trang điểm nổi tiếng và các sao trên toàn thế giới tin dùng. Với đa đạng về màu sắc và kiểu cách son MAC thích hợp với nhiều đối tượng mang đến cho người dùng sự gợi cảm, sang trọng và quyến rũ giúp bạn nỗi bật dưới mọi ánh nhìn.</p>');
INSERT INTO brand (brand_name, brand_description) VALUES (N'3CE', N'<p><span class="fw-medium">3CE</span> có tên gọi là Concept Eyes đến từ xứ kim chi, thành lập vào tháng 1/2009. Với hơn 10 năm sự nghiệp, <span class="fw-medium">3CE</span> đã nhanh chóng phổ biến trên thị trường với nhiều mặt hàng thời trang và mỹ phẩm. Trong đó mỹ phẩm <span class="fw-medium">3CE</span> luôn làm cho tín đồ làm đẹp trên Thế Giới “điên đảo”.</p>
<p><span class="fw-medium">3CE</span> nổi tiếng nhanh chóng nhờ vào các dòng mỹ phẩm với những màu sắc hiện đại. Những sản phẩm từ hãng luôn dẫn đầu trào lưu của khi vừa mới ra mắt. Từ kem nền, phấn phủ đến phấn mắt, Mascara, cọ trang điểm… Và tiêu biểu nhất chính là <span class="fw-medium">son 3CE</span>.</p>
<p>Ngoài Hàn Quốc, nhãn hàng đình đám này đã có tới hơn 150 cửa hàng ở nhiều nơi như Trung Quốc, Hong Kong, Thái Lan, Singapore và Nhật Bản. Tại Việt Nam, <span class="fw-medium">son 3CE</span> rất được đông đảo các tín đồ làm đẹp yêu thích vì giá thành phải chăng cùng chất lượng tuyệt vời.</p>');


INSERT INTO category (category_name) VALUES (N'Son Thỏi');
INSERT INTO category (category_name) VALUES (N'Son Kem');
INSERT INTO category (category_name) VALUES (N'Son Dưỡng');


INSERT INTO product (product_name, product_color, product_image, product_price, product_quantity, product_short_description, product_description, category_id, brand_id) VALUES (N'Son YSL Slim Velvet 21 Rouge Paradoxe', N'Màu Đỏ Ruby', N'son-ysl-slim-velvet-21-rouge-paradox.png', 950000, 10, N'Son YSL Slim Velvet 21 Rouge Paradoxe – Màu Đỏ Ruby ra đời đã khiến nhiều tín đồ mê làm đẹp nhanh tay đặt hàng bởi màu son đỏ ruby thời thượng cùng chất son lì với kết cấu mềm mại như nhung mịn màng khiến nàng thích thú.', null, 1, 4);
INSERT INTO product (product_name, product_color, product_image, product_price, product_quantity, product_short_description, product_description, category_id, brand_id) VALUES (N'Son YSL The Slim Glow Matte – 214 Illicit Orange', N'Cam cháy', N'son-ysl-slim-214-illicit-orange.jpg', 890000, 10, N'YSL tiếp tuc tung ra một siêu phẩm son nhỏ gọn mang tên Son YSL The Slim Glow Matte – 214 Illicit Orange. Từ khi ra mắt đến bây giờ cây  son nhỏ nhưng có võ của nhà YSL chưa bao giờ là hết sốt với các chị em.', null, 1, 4);
INSERT INTO product (product_name, product_color, product_image, product_price, product_quantity, product_short_description, product_description, category_id, brand_id) VALUES (N'Son Kem YSL Vinyl Cream Lip Stain 441 Arcade Chili', N'Màu Đỏ Cam Gạch', N'son-kem-ysl-vinyl-cream-lip-stain-441-arcade-chili.png', 1250000, 10, N'Son Kem YSL Vinyl Cream Lip Stain 441 Arcade Chili – Màu Đỏ Cam Gạch là thỏi son được các chị em săn đón nhiều nhất trong thời gian gần đây. Thuộc thương hiệu nổi tiếng nên YSL 441 sở hữu chất son kem mềm mịn cùng độ giữ màu lên tới 10 giờ đồng hồ đã khiến chị em đứng ngồi không yên ngay từ khi mới ra mắt.', null, 2, 4);
INSERT INTO product (product_name, product_color, product_image, product_price, product_quantity, product_short_description, product_description, category_id, brand_id) VALUES (N'Son Kem YSL Vinyl Cream Lip Stain 610 Nude Champion', N'Màu Cam', N'son-kem-ysl-vinyl-cream-lip-stain-610-nude-champion.png', 1250000, 12, N'Son Kem YSL Vinyl Cream Lip Stain 610 Nude Champion – Màu Cam Nude gây ấn tượng với phái đẹp bởi màu son nhẹ nhàng, tự nhiên nhưng vẫn vô cùng cuốn hút và quyến rũ. Đặc biệt chất son kem mềm mịn, giữ màu lên tới 10 giờ đã làm chị em phải nhanh tay đặt hàng ngay từ khi mới ra mắt.', null, 2, 4);
INSERT INTO product (product_name, product_color, product_image, product_price, product_quantity, product_short_description, product_description, category_id, brand_id) VALUES (N'Son YSL The Bold 07 Unihibited Flame', N'Màu Đỏ Tươi Ánh Cam (New)', N'son-ysl-the-bold-07-unihibited-flame.png', 950000, 10, N'Son YSL The Bold 07 Unihibited Flame – Màu Đỏ Tươi Ánh Cam là một trong thỏi son cao cấp nhà YSL được ưa chuộng bởi màu son tươi sáng, trẻ trung nhưng cũng không kém phần sang trọng và quyến rũ.', null, 1, 4);
INSERT INTO product (product_name, product_color, product_image, product_price, product_quantity, product_short_description, product_description, category_id, brand_id) VALUES (N'Son YSL Rouge Volupte Shine Collector', N'Đỏ Cherry', N'son-ysl-rouge-volupte-shine-collector.jpg', 950000, 10, N'Tone đỏ cherry nóng bỏng kết hợp cùng chất son satin cực mịn được “bao bọc” bởi lớp vỏ “nữ quyền” giúp cho Son YSL Rouge Volupte Shine Collector Màu Take My Red Away 120 khiến cho chị em không thể ngồi yên.', null, 1, 4);
INSERT INTO product (product_name, product_color, product_image, product_price, product_quantity, product_short_description, product_description, category_id, brand_id) VALUES (N'Son YSL Rouge Volupte Candy Glaze 9 Tangerine Tease', N'Màu Đỏ Tươi Ánh Cam', N'son-ysl-rouge-volupte-candy-glaze-9-tangerine-tease.jpg', 890000, 10, N'Màu son lên môi nhẹ nhàng, tự nhiên, vẫn chất son “nguyên bản” siêu cấp ẩm với độ bóng nhẹ trên làn môi, Son YSL Rouge Volupte Candy Glaze 9 Tangerine Tease – Màu Đỏ Tươi Ánh Cam lên môi một cách tự nhiên và quyến rũ lạ kỳ.', null, 1, 4);
INSERT INTO product (product_name, product_color, product_image, product_price, product_quantity, product_short_description, product_description, category_id, brand_id) VALUES (N'Son Chanel Rouge Allure Luminous Intense 212 Caractère', N'Màu Đỏ Nâu', N'son-chanel-rough-allure-luminous-intense-212-caractete.png', 1050000, 20, N'Son Chanel Rouge Allure Luminous Intense 212 Caractère – Màu Đỏ Nâu với tông màu cực trendy thời thượng chắc chắn sẽ không làm chị em thất vọng. Sở hữu thiết kế xinh đẹp, màu son thời thượng cùng chất son hoàn hảo, Chanel 212 Caractère dễ dàng trở thành gương mặt ưu tú trong những thỏi son được ưu chuộng.', null, 1, 1);


INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-slim-velvet-21-rouge-paradox.png', 1);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-slim-velvet-21-rouge-paradox_1.png', 1);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-slim-velvet-21-rouge-paradox_2.png', 1);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-slim-velvet-21-rouge-paradox_3.png', 1);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-slim-velvet-21-rouge-paradox_4.png', 1);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-slim-214-illicit-orange.jpg', 2);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-slim-214-illicit-orange_1.jpg', 2);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-slim-214-illicit-orange_2.jpg', 2);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-slim-214-illicit-orange_3.jpg', 2);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-slim-214-illicit-orange_4.jpg', 2);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-kem-ysl-vinyl-cream-lip-stain-441-arcade-chili.png', 3);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-kem-ysl-vinyl-cream-lip-stain-441-arcade-chili_1.png', 3);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-kem-ysl-vinyl-cream-lip-stain-441-arcade-chili_2.png', 3);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-kem-ysl-vinyl-cream-lip-stain-441-arcade-chili_3.png', 3);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-kem-ysl-vinyl-cream-lip-stain-441-arcade-chili_4.png', 3);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-kem-ysl-vinyl-cream-lip-stain-610-nude-champion.png', 4);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-kem-ysl-vinyl-cream-lip-stain-610-nude-champion_1.png', 4);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-kem-ysl-vinyl-cream-lip-stain-610-nude-champion_2.png', 4);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-kem-ysl-vinyl-cream-lip-stain-610-nude-champion_3.png', 4);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-kem-ysl-vinyl-cream-lip-stain-610-nude-champion_4.png', 4);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-the-bold-07-unihibited-flame.png', 5);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-the-bold-07-unihibited-flame_1.jpg', 5);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-the-bold-07-unihibited-flame_2.jpg', 5);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-the-bold-07-unihibited-flame_3.jpg', 5);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-the-bold-07-unihibited-flame_4.jpg', 5);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-rouge-volupte-shine-collector.jpg', 6);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-rouge-volupte-shine-collector_1.jpg', 6);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-rouge-volupte-shine-collector_2.jpg', 6);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-rouge-volupte-shine-collector_3.jpg', 6);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-rouge-volupte-candy-glaze-9-tangerine-tease.jpg', 7);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-rouge-volupte-candy-glaze-9-tangerine-tease_1.jpg', 7);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-rouge-volupte-candy-glaze-9-tangerine-tease_2.jpg', 7);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-rouge-volupte-candy-glaze-9-tangerine-tease_3.jpg', 7);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-ysl-rouge-volupte-candy-glaze-9-tangerine-tease_4.jpg', 7);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-chanel-rough-allure-luminous-intense-212-caractete.png', 8);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-chanel-rough-allure-luminous-intense-212-caractete_1.png', 8);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-chanel-rough-allure-luminous-intense-212-caractete_2.png', 8);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-chanel-rough-allure-luminous-intense-212-caractete_3.png', 8);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-chanel-rough-allure-luminous-intense-212-caractete_4.png', 8);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-chanel-rough-allure-luminous-intense-212-caractete_5.png', 8);
INSERT INTO product_image (product_image, product_id) VALUES (N'son-chanel-rough-allure-luminous-intense-212-caractete_6.png', 8);


INSERT INTO order_status (order_status) VALUES (N'Chờ xác nhận');
INSERT INTO order_status (order_status) VALUES (N'Đã xác nhận');
INSERT INTO order_status (order_status) VALUES (N'Đang chuẩn bị hàng');
INSERT INTO order_status (order_status) VALUES (N'Đang giao');
INSERT INTO order_status (order_status) VALUES (N'Hoàn thành');
INSERT INTO order_status (order_status) VALUES (N'Đã huỷ');
INSERT INTO order_status (order_status) VALUES (N'Trả hàng');
