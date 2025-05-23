INSERT INTO users (user_name, password, profile_img_url, user_nickname,self_introduction,role) VALUES ( 'admin1', '$2a$10$utd1m3OuHdqfpUKM8GNDAeYqTWB5ycrTOPZ9NUVNpiFlmaxNqhmFO', NULL, 'Administrator', '관리자계정','ADMIN');
INSERT INTO users (user_name, password, profile_img_url, user_nickname,self_introduction,role) VALUES ( 'goodseller1', '$2a$10$utd1m3OuHdqfpUKM8GNDAeYqTWB5ycrTOPZ9NUVNpiFlmaxNqhmFO', NULL, '굿셀러','좋은 상품만 모아 팝니다' ,'SELLER');
INSERT INTO users (user_name, password, profile_img_url, user_nickname,self_introduction, role) VALUES ( 'goodseller2', '$2a$10$utd1m3OuHdqfpUKM8GNDAeYqTWB5ycrTOPZ9NUVNpiFlmaxNqhmFO', NULL, '우수판매원','품질이 좋은 제품만을 고집합니다.', 'SELLER');
INSERT INTO users (user_name, password, profile_img_url, user_nickname,self_introduction, role) VALUES ('customer1', '$2a$10$utd1m3OuHdqfpUKM8GNDAeYqTWB5ycrTOPZ9NUVNpiFlmaxNqhmFO', NULL, 'VIP고객','좋은걸 살테니 좋은 것좀 올려주세요', 'BUYER');
INSERT INTO users (user_name, password, profile_img_url, user_nickname,self_introduction, role) VALUES ( 'multiUser1', '$2a$10$utd1m3OuHdqfpUKM8GNDAeYqTWB5ycrTOPZ9NUVNpiFlmaxNqhmFO', NULL, 'bestProduct','좋은것도 사고 좋은 물건도 올려드립니다.', 'BOTH');
INSERT INTO users (user_name, password, profile_img_url, user_nickname,self_introduction, role) VALUES ( 'sellerA', 'pass1234', NULL, '한개만팜','딱 한개의 물품만을 취급합니다.', 'SELLER');
INSERT INTO users (user_name, password, profile_img_url, user_nickname,self_introduction, role)VALUES ( 'sellerB', 'pass1234', NULL, '판매다양', '품질좋은 물품 여러개를 취급힙니다.','SELLER');
INSERT INTO users (user_name, password, profile_img_url, user_nickname,self_introduction, role) VALUES ( 'buyer01', 'pass1234', NULL, 'VVIP고객','많이 많이 사겠습니다?' ,'BUYER');
INSERT INTO users (user_name, password, profile_img_url, user_nickname,self_introduction, role) VALUES ( 'multiUser2', '$2a$10$utd1m3OuHdqfpUKM8GNDAeYqTWB5ycrTOPZ9NUVNpiFlmaxNqhmFO', NULL, '평판좋음','별점 5개를 목표로 합니다. 좋은 물건도 삽니다.', 'BOTH');
/*사용자 9명 실질 판매자 5명*/
COMMIT;
/*샘플 상품 70개*/
INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '자', 'image/stationery/ruler.jpg', '정확한 측정을 위한 자입니다.', 700, 5, 400);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '포스트잇 메모', 'image/stationery/postit.jpg', '다채로운 포스트잇 메모입니다.', 900, 2, 350);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '신선한 당근', 'image/fresh/carrot.jpg', '바삭한 신선한 당근입니다.', 1200, 2, 120);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '김 튀각', 'image/snacks/gimsnack.jpg', '한국 전통의 김 튀각입니다. '||
                                                       '바삭하면서도 김의 풍미가 살아 있습니다.', 3300, 7, 170);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '꼬꼬면(30입)', 'image/instantFood/kkokkomyeon.jpg', '한국식 닭 육수 라면입니다.', 15900, 1, 300);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '떡볶이 과자', 'image/snacks/ddeokbokki.jpg', '떡볶이 맛 과자로 매콤한 즐거움을 선사합니다.', 4400, 2, 210);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '매운 우동', 'image/instantFood/spicyudong.jpg', '매콤한 국물의 우동입니다.', 3300, 3, 240);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '필통', 'image/stationery/pencilcase.jpg', '가죽으로 고급스럽게 디자인된 필통입니다.', 10900, 7, 160);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '싱그러운 토마토', 'image/fresh/tomato.jpg', '싱그러운 맛의 토마토입니다.', 1200, 9, 65);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '팔도비빔면', 'image/instantFood/bibimmyeon.jpg', '역사가 깊고 매콤달콤한 팔도비빔면입니다.', 3100, 9, 280);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '맛있는 프레첼', 'image/snacks/pretzel.jpg', '담백하고 고소한 프레첼입니다.', 3200, 2, 150);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '야채 수프', 'image/instantFood/vegetablesoup.jpg', '다양한 야채가 들어간 수프 컵입니다.', 3100, 5, 320);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '순두부 찌개', 'image/instantFood/sundubjjigae.jpg', '부드러운 순두부가 일품인 찌개입니다.', 3500, 7, 330);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '럼주', 'image/alcohols/rum.jpg', '맛 좋은 럼주입니다.', 13500, 2, 30);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '샤프 펜슬', 'image/stationery/sharpencil.jpg', '섬세한 필기를 위한 샤프 펜슬입니다.', 1200, 5, 300);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '지우개', 'image/stationery/eraser.jpg', '깨끗하게 지울 수 있는 지우개입니다.', 800, 9, 400);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '밀양 탁주', 'image/alcohols/takju.jpg', '밀양에서 특유의 방법으로 직접 빚어' ||
                                                         '부드럽고 달콤한 탁주입니다.', 13500, 7, 55);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '해물 라면', 'image/instantFood/seafoodramen.jpg', '다양한 해물이 어우러진 라면입니다.', 3800, 1, 250);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '고소한 감자칩', 'image/snacks/gamjachip.jpg', '바삭한 감자칩으로 간식을 즐기세요.', 3500, 1, 200);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '보드카', 'image/alcohols/vodka.jpg', '깔끔하고 목넘김이 강한 보드카입니다.', 10000, 7, 80);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '초콜릿 바', 'image/snacks/chocolatebar.jpg', '달콤한 초콜릿 바입니다.', 3800, 7, 250);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '유기농 사과', 'image/fresh/apple.jpg', '신선한 유기농 사과입니다.', 1500, 1, 100);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '고래밥', 'image/snacks/gorebob.jpg', '고추맛이 매력적인 스낵입니다.', 3900, 1, 180);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '가위','image/stationery/scissor.jpg','아주 잘 잘리는 고품질 가위입니다.',1200,2,200);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '샤인머스켓와인', 'image/alcohols/fruitwine.jpg', '샤인머스켓이 잘 익었을때 수확 하여,' ||
                                                               '과일의 풍미가 가득한 과실주입니다.', 23000, 9, 35);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '데스크 캘린더 2025', 'image/stationery/deskcalendar.jpg', '2025년 데스크 캘린더입니다.', 2200, 1, 180);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '꿀 아몬드', 'image/snacks/sugaralmond.jpg', '꿀에 절인 아몬드입니다.', 4200, 2, 190);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '마커 세트', 'image/stationery/markerset.jpg', '선명한 색상의 마커 세트입니다.', 2100, 3, 170);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '클립 세트', 'image/stationery/paperclips.jpg', '문서 정리에 유용한 클립 세트입니다.', 1500, 5, 193);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '수입 위스키', 'image/alcohols/importwhisky.jpg', '수입산 위스키로 깊은 맛을 느껴보세요.', 15000, 5, 70);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '수제 맥주', 'image/alcohols/craftbeer.jpg', '정성이 담긴 수제 맥주입니다.', 9000, 3, 60);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '오뚜기 진짬뽕', 'image/instantFood/jinjjamppong.jpg', '짬뽕이 생각날때 간편하게 먹을 수 있는 진짬뽕입니다.', 3500, 6, 800);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '데리야끼치킨버거(8개입)', 'image/instantFood/chickenburger.jpg', '데리야끼 소스로 맛을 낸 치킨버거입니다.', 38000, 3, 90);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '신선한 수박', 'image/fresh/watermelon.jpg', '여름철 시원한 수박입니다.', 2000, 7, 50);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '즉석 볶음밥', 'image/instantFood/instantbokkeumbap.jpg', '간편하게 데워 먹기만 하면 되는 볶음밥입니다.', 3000, 7, 350);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '아삭한 오이', 'image/fresh/cucumber.jpg', '아삭한 식감의 오이입니다.', 1100, 5, 80);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '오뚜기 3분 카레', 'image/instantFood/threemincurry.jpg', '3분만 조리하면 맛있는 카레가 뚝딱', 3200, 2, 260);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '고급 노트', 'image/stationery/note.jpg', '고급 재질의 노트입니다.', 1500, 1, 200);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '잘 익은 바나나', 'image/fresh/banana.jpg', '자연 그대로의 잘 익은 바나나입니다.', 1400, 9, 110);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '오징어 땅콩', 'image/snacks/squidpeanut.jpg', '오징어와 땅콩의 조합입니다.', 4100, 9, 200);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '치즈 크래커', 'image/snacks/cheesecracker.jpg', '치즈의 풍미가 가득한 크래커입니다.', 4000, 3, 180);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '호로요이', 'image/alcohols/horoyoi.jpg', '술 잘 못하는 분도 쉽게 마실수 있는' ||
                                                          ' 산토리 호로요이!', 4500, 2, 85);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '달콤한 망고', 'image/fresh/mango.jpg', '달콤하고 부드러운 망고입니다.', 1800, 7, 70);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '아삭한 브로콜리', 'image/fresh/broccoli.jpg', '풍부한 영양의 아삭한 브로콜리입니다.', 1400, 2, 100);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '매콤 나쵸', 'image/snacks/nachos.jpg', '매콤한 맛의 나쵸입니다.', 4500, 3, 230);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '시래기된장국(3개입)', 'image/instantFood/doenjangguk.jpg', '사골국물로 맛을 낸 ' ||
                                                                           '전통 시래기 된장국 맛을 느껴보세요.', 15900, 2, 120);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '브랜디', 'image/alcohols/brandy.jpg', '향이 풍부한 브랜디입니다.', 19500, 1, 100);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '스케치북', 'image/stationery/sketchbook.jpg', '자라나는 아동을 위한 스케치북입니다.', 3500, 3, 160);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '바삭한 새우칩 1kg', 'image/snacks/shrimpchip.jpg', '새우의 맛을 바삭하게 느낄 수 있는 칩입니다.', 5400, 5, 240);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '과일 젤리', 'image/snacks/fruitjelly.jpg', '상큼한 과일 젤리입니다.', 3400, 1, 260);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '토마토 파스타', 'image/instantFood/tomatopasta.jpg', '토마토 베이스의 파스타 수프입니다.', 3400, 9, 290);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '믹스 넛츠', 'image/snacks/mixnuts.jpg', '여러 견과류가 혼합된 넛츠입니다.', 5000, 5, 220);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '달달한 미국산 만다린', 'image/fresh/mandarin.jpg', '머나먼 미국에서 건너온 영양만점 만다린입니다.', 1500, 3, 75);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '싱싱한 상추', 'image/fresh/lettuce.jpg', '싱그러운 상추로 샐러드용입니다.', 1300, 3, 90);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '소주', 'image/alcohols/soju.jpg', '깔끔하고 청량한 맛의 소주입니다.', 8500, 1, 75);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '짜장면', 'image/instantFood/jajangmyeon.jpg', '진한 짜장 소스의 짜장면입니다.', 3300, 5, 300);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '청주', 'image/alcohols/chungju.jpg', '옛 방식으로 만든 전통 청주입니다.', 10500, 5, 65);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '향긋한 복숭아', 'image/fresh/peach.jpg', '향긋하고 즙이 많은 복숭아입니다.', 1600, 2, 85);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('instantFood', '햇반', 'image/instantFood/instantrice.jpg', '간편하게 데워서 갓 지은 밥의 맛을 느껴보세요.', 900, 1, 280);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '형광펜 세트', 'image/stationery/highlighterset.jpg', '다양한 색상의 형광펜 세트입니다.', 2000, 7, 220);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '촉촉한 파프리카', 'image/fresh/paprika.jpg', '촉촉하고 아삭한 파프리카입니다.', 1100, 1, 55);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '신선한 딸기', 'image/fresh/strawberry.jpg', '싱싱한 딸기로 상큼함을 느껴보세요.', 1700, 1, 95);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('Fresh', '탱글한 포도', 'image/fresh/grape.jpg', '탱글탱글한 포도송이입니다.', 1300, 5, 60);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '투명 테이프', 'image/stationery/cleartape.jpg', '다용도로 사용 가능한 투명 테이프입니다.', 1000, 7, 190);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '프리미엄 레드와인', 'image/alcohols/redwine.jpg', '현지 포도밭에서 생산된 프리미엄 레드와인입니다.', 12000, 1, 50);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '클래식 화이트와인', 'image/alcohols/whitewine.jpg', '신선한 느낌의 클래식 화이트와인입니다.', 11000, 2, 40);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('snacks', '풍미 팝콘', 'image/snacks/popcorn.jpg', '영화와 함께하는 팝콘입니다.', 3600, 9, 210);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('stationery', '볼펜 세트', 'image/stationery/penset.jpg', '정밀하게 쓰기 좋은 볼펜 세트입니다.', 1800, 2, 250);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '스파클링 샴페인', 'image/alcohols/champagne.jpg', '기분 좋은 순간을 위한 샴페인입니다.', 13000, 9, 90);

INSERT INTO product (product_category, product_name, product_img_url, product_description, product_price, product_user_no, product_quantity)
VALUES ('alcohols', '오크통 버번', 'image/alcohols/bourbon.jpg', '오크 숙성의 버번입니다.', 12500, 3, 55);


UPDATE product
SET  product_added_at = CAST(TO_CHAR(SYSDATE - (DBMS_RANDOM.VALUE(3600*24*15, 3600*24*30)/24/60/60) , 'YYYY-MM-DD HH24:MI:SS')as timestamp)
WHERE product_added_at>SYSTIMESTAMP;
COMMIT;

/*위시리스트*/
INSERT INTO wishList (wish_user_no, wish_product_no)
VALUES (8, 43);

INSERT INTO wishList (wish_user_no, wish_product_no)
VALUES (9, 13);

INSERT INTO wishList (wish_user_no, wish_product_no)
VALUES (4, 33);

INSERT INTO wishList (wish_user_no, wish_product_no)
VALUES (1, 48);

INSERT INTO wishList (wish_user_no, wish_product_no)
VALUES (2, 24);
UPDATE WISHLIST
SET ADDED_AT = CAST(TO_CHAR(SYSDATE - (DBMS_RANDOM.VALUE(0, 3600*24*5)/24/60/60) , 'YYYY-MM-DD HH24:MI:SS')as timestamp)
WHERE added_at>SYSTIMESTAMP;
COMMIT;

/*장바구니 목록*/
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (21, 8, 3);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (16, 5, 2);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (33, 8, 2 );
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (25, 9, 2);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (37, 9, 2);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (35, 1, 2);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (12, 4, 1);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (58, 5, 3);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (21, 8, 1);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (63, 9, 2);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (7, 1, 1);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (49, 4, 4);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (18, 9, 1);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (68, 8, 2);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (3, 9, 1);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (51, 1, 3);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (29, 4, 1);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (65, 9, 2);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (10, 8, 1);
INSERT INTO cartItemList (product_no, list_user_no, quantity)
VALUES (42, 9, 5);

UPDATE cartItemList
SET  added_at = CAST(TO_CHAR(SYSDATE - (DBMS_RANDOM.VALUE(3600*24*6, 3600*24*14)/24/60/60) , 'YYYY-MM-DD HH24:MI:SS')as timestamp)
WHERE added_at>SYSTIMESTAMP;
commit;

/*여기는 userDetails(잊어먹고 나중에 넣음)*/
INSERT INTO userDetails (detail_user_no, email, phone, privacy_agreements,marketing_agreements,  birth_date, name)
VALUES (1, 'admin1@example.com', '01011111111', 1, 0,  TO_TIMESTAMP('1990-01-01', 'YYYY-MM-DD'), '김관리');

INSERT INTO userDetails (detail_user_no, email, phone, privacy_agreements,marketing_agreements,  birth_date, name)
VALUES ( 2, 'goodseller1@example.com', '01022222222', 1, 1,  TO_TIMESTAMP('1985-03-15', 'YYYY-MM-DD'), '박판매');

INSERT INTO userDetails (detail_user_no, email, phone, privacy_agreements,marketing_agreements,  birth_date, name)
VALUES (3, 'goodseller2@example.com', '01033333333', 1, 1, TO_TIMESTAMP('1982-07-21', 'YYYY-MM-DD'), '이우수');

INSERT INTO userDetails (detail_user_no, email, phone, privacy_agreements,marketing_agreements,  birth_date, name)
VALUES (4, 'customer1@example.com', '01044444444', 1, 0, TO_TIMESTAMP('1995-09-10', 'YYYY-MM-DD'), '최고객');

INSERT INTO userDetails (detail_user_no, email, phone, privacy_agreements,marketing_agreements,  birth_date, name)
VALUES (5, 'multiUser1@example.com', '01055555555', 1, 1, TO_TIMESTAMP('1991-12-25', 'YYYY-MM-DD'), '정복합');

INSERT INTO userDetails (detail_user_no, email, phone, privacy_agreements,marketing_agreements,  birth_date, name)
VALUES (6, 'sellerA@example.com', '01066666666', 1, 0,  TO_TIMESTAMP('1988-06-01', 'YYYY-MM-DD'), '한판매');

INSERT INTO userDetails (detail_user_no, email, phone, privacy_agreements,marketing_agreements,  birth_date, name)
VALUES (7, 'sellerB@example.com', '01077777777', 1, 1,  TO_TIMESTAMP('1993-08-18', 'YYYY-MM-DD'), '양다양');

INSERT INTO userDetails (detail_user_no, email, phone, privacy_agreements,marketing_agreements,  birth_date, name)
VALUES (8, 'buyer01@example.com', '01088888888', 1, 1,  TO_TIMESTAMP('1999-02-02', 'YYYY-MM-DD'), '구매왕');

INSERT INTO userDetails (detail_user_no, email, phone, privacy_agreements,marketing_agreements,  birth_date, name)
VALUES (9, 'multiUser2@example.com', '01099999999', 1, 0,  TO_TIMESTAMP('1994-11-30', 'YYYY-MM-DD'), '홍사용');
UPDATE USERDETAILS
SET  created_at = CAST(TO_CHAR(SYSDATE - (DBMS_RANDOM.VALUE(3600*24*31, 3600*24*40)/24/60/60) , 'YYYY-MM-DD HH24:MI:SS')as timestamp)
WHERE created_at>SYSTIMESTAMP;
UPDATE USERDETAILS
SET  birth_date = CAST(TO_CHAR(SYSDATE - (DBMS_RANDOM.VALUE(3600*24*365*25, 3600*24*365*35)/24/60/60) , 'YYYY-MM-DD')as timestamp)
WHERE birth_date IS NOT NULL;
COMMIT;