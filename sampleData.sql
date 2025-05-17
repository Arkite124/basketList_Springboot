INSERT INTO "users" ("user_id", "user_name", "password", "profile_img_url", "user_nickname", "role") VALUES (1, 'admin1', 'pass1234', NULL, '관리자', 'ADMIN');
INSERT INTO "users" ("user_id", "user_name", "password", "profile_img_url", "user_nickname", "role") VALUES (2, 'goodseller1', 'pass1234', NULL, '굿셀러', 'SELLER');
INSERT INTO "users" ("user_id", "user_name", "password", "profile_img_url", "user_nickname", "role") VALUES (3, 'goodseller2', 'pass1234', NULL, '우수판매원', 'SELLER');
INSERT INTO "users" ("user_id", "user_name", "password", "profile_img_url", "user_nickname", "role") VALUES (4, 'customer1', 'pass1234', NULL, 'VIP고객', 'BUYER');
INSERT INTO "users" ("user_id", "user_name", "password", "profile_img_url", "user_nickname", "role") VALUES (5, 'multiUser1', 'pass1234', NULL, '상품좋음', 'BOTH');
INSERT INTO "users" ("user_id", "user_name", "password", "profile_img_url", "user_nickname", "role") VALUES (6, 'sellerA', 'pass1234', NULL, '한개만팜', 'SELLER');
INSERT INTO "users" ("user_id", "user_name", "password", "profile_img_url", "user_nickname", "role") VALUES (7, 'sellerB', 'pass1234', NULL, '판매다양', 'SELLER');
INSERT INTO "users" ("user_id", "user_name", "password", "profile_img_url", "user_nickname", "role") VALUES (8, 'buyer01', 'pass1234', NULL, 'VVIP고객', 'BUYER');
INSERT INTO "users" ("user_id", "user_name", "password", "profile_img_url", "user_nickname", "role") VALUES (9, 'multiUser2', 'pass1234', NULL, '평판좋음', 'BOTH');
/*사용자 9명 실질 판매자 3명*/
INSERT INTO "product" ("product_category", "product_name", "product_img_url", "product_description", "product_price", "product_user_no", "product_quantity") VALUES
-- Alcohols
('alcohols', '청하', 'image/alcohols/cheongha.jpg', '부드러운 청하 소주입니다.', 3000, 1, 20),
('alcohols', '참이슬 후레쉬', 'image/alcohols/chamisul.jpg', '시원한 맛의 참이슬입니다.', 2500, 2, 10),
('alcohols', '카스 맥주', 'image/alcohols/cass.jpg', '시원한 국산 맥주입니다.', 3000, 3, 50),
('alcohols', '처음처럼', 'image/alcohols/firstsoju.jpg', '부드러운 소주 처음처럼.', 2500, 1, 0),
('alcohols', '하이트 진로', 'image/alcohols/hite.jpg', '국산 인기 맥주 하이트.', 2800, 4, 15),
('alcohols', '필라이트', 'image/alcohols/filite.jpg', '가성비 맥주 필라이트.', 1800, 5, 8),

-- Fresh
('fresh', '유기농 시금치', 'image/fresh/spinach.jpg', '신선한 유기농 시금치입니다.', 1500, 3, 10),
('fresh', '친환경 토마토', 'image/fresh/tomato.jpg', '달콤한 토마토!', 1800, 2, 13),
('fresh', '무농약 상추', 'image/fresh/lettuce.jpg', '건강한 상추입니다.', 1200, 5, 20),
('fresh', '오이', 'image/fresh/cucumber.jpg', '시원한 오이입니다.', 1000, 1, 25),
('fresh', '당근', 'image/fresh/carrot.jpg', '건강한 당근입니다.', 1300, 4, 12),
('fresh', '브로콜리', 'image/fresh/broccoli.jpg', '항산화 브로콜리!', 1700, 2, 0),

-- InstantFood
('instantFood', '삼각김밥 참치마요', 'image/instantFood/tunamayo.jpg', '맛있는 참치마요!', 1200, 2, 50),
('instantFood', '컵라면 신라면', 'image/instantFood/shinramen.jpg', '국민 컵라면 신라면.', 1300, 1, 80),
('instantFood', '햇반', 'image/instantFood/hetban.jpg', '전자레인지 2분 밥!', 1100, 3, 60),
('instantFood', '즉석카레', 'image/instantFood/curry.jpg', '3분 카레입니다.', 2000, 4, 35),
('instantFood', '오뚜기 미역국', 'image/instantFood/miyeok.jpg', '간편한 미역국', 2100, 5, 10),
('instantFood', '짜파게티 컵', 'image/instantFood/jjapaghetti.jpg', '진한 맛의 짜파게티', 1400, 1, 5),

-- Snacks
('snacks', '허니버터칩', 'image/snacks/honeychip.jpg', '단짠 허니버터칩.', 2000, 2, 25),
('snacks', '꼬북칩 초코', 'image/snacks/kobuk.jpg', '초코맛 꼬북칩입니다.', 1800, 4, 40),
('snacks', '포카칩 오리지널', 'image/snacks/pocachip.jpg', '바삭한 감자칩!', 1900, 3, 15),
('snacks', '빼빼로', 'image/snacks/pepero.jpg', '달콤한 초코스틱.', 1200, 5, 18),
('snacks', '새우깡', 'image/snacks/shrimp.jpg', '국민 과자 새우깡!', 1000, 1, 22),
('snacks', '초코파이', 'image/snacks/choco.jpg', '정 겨운 초코파이.', 1600, 7, 8),

-- Frozen
('frozen', '냉동만두', 'image/frozen/dumpling.jpg', '전자렌지 OK!', 3500, 7, 13),
('frozen', '냉동피자', 'image/frozen/pizza.jpg', '치즈가 가득!', 5000, 2, 6),
('frozen', '닭가슴살 볼', 'image/frozen/chickenball.jpg', '헬스용 식단.', 3200, 6, 100),
('frozen', '냉동볶음밥', 'image/frozen/friedrice.jpg', '간편한 한끼!', 2700, 4, 21),
('frozen', '냉동감자튀김', 'image/frozen/fries.jpg', '바삭한 감자', 2500, 1, 30),
('frozen', '냉동핫도그', 'image/frozen/hotdog.jpg', '치즈핫도그!', 3000, 7, 9);
