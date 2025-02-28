-- Active: 1740220355320@@127.0.0.1@3306@ai_fitness
-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 25, 2025 lúc 12:07 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

DROP DATABASE IF EXISTS `cinemamodels`;
CREATE DATABASE IF NOT EXISTS `cinemamodels` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cinemamodels`;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cinemamodels`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `actors`
--

CREATE TABLE `actors` (
  `actor_id` int(11) NOT NULL,
  `actor_name` varchar(255) NOT NULL,
  `date_of_birth` date NOT NULL,
  `country` varchar(255) NOT NULL,
  `actor_description` varchar(255) DEFAULT NULL,
  `avatar_img` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `actors`
--

INSERT INTO `actors` (`actor_id`, `actor_name`, `date_of_birth`, `country`, `actor_description`, `avatar_img`) VALUES
(1, 'Leonardo DiCaprio', '1974-11-11', 'USA', 'Los Angeles', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSmwp2FN8D37uXr4yf3QzIx-KoGFNYGsYRqY4IykjK2Q4DrCoc6OI5-EiKyncabkdRby_TldiF7MmgRYD7oOwLZNA'),
(2, 'Christian Bale', '1974-01-30', 'UK', 'Haverfordwest', 'https://m.media-amazon.com/images/M/MV5BMTkxMzk4MjQ4MF5BMl5BanBnXkFtZTcwMzExODQxOA@@._V1_FMjpg_UX1000_.jpg'),
(3, 'Kate Winslet', '1975-10-05', 'UK', 'Reading', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTybqHgJgSDs0XFdLOw2MDtrrfwBl6lQlAGn2v1VZIjO_9c1EePRkqCALHdZpr6QCvi525mmdO5UyUyZeng5eJjMA'),
(4, 'Heath Ledger', '1979-04-04', 'Australia', 'Perth', 'https://hips.hearstapps.com/hmg-prod/images/heath_ledger_getty_images_photo_bob_riha_jr_wireimage_116948085.jpg?crop=1.00xw:0.502xh;0,0.319xh&resize=1200:*'),
(5, 'Oda Eiichiro', '1975-01-01', 'Japan', 'Kumamoto', 'https://i.ytimg.com/vi/MZVygd1oOXs/maxresdefault.jpg'),
(6, 'Joseph Gordon-Levitt', '1981-02-17', 'USA', 'Los Angeles', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRS1YQqDWYm_2u_JB0p_lzHhXT0Ev0d4CqxEUaONZ-8JzqQjuytdAzJP8caj_8ZKeZT3ZQyIrIhye1L1wmA6e5nRZMeTbWOFgsQcj4NRio'),
(7, 'Matthew McConaughey', '1969-11-04', 'USA', 'Uvalde', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXVWSOKavx2cNSf3bl_RZ-I8j4ef51Lwuycm7n2Csdg_dwz6WBQ86bZghsklAu7ZYNanc1guyY-SsLYnCpaes_ow'),
(8, 'Anne Hathaway', '1982-11-12', 'USA', 'Brooklyn', 'https://i.scdn.co/image/09f4a0a499359540e40075f8e912d7c3e94bc4a6'),
(9, 'Mayumi Tanaka', '1955-01-15', 'Japan', 'Tokyo', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/28/Mayumi_Tanaka_2023.jpg/640px-Mayumi_Tanaka_2023.jpg'),
(10, 'Keanu Reeves', '1964-09-02', 'Canada', 'Beirut', 'https://m.media-amazon.com/images/M/MV5BNDEzOTdhNDUtY2EyMy00YTNmLWE5MjItZmRjMmQzYTRlMGRkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg'),
(11, 'Carrie-Anne Moss', '1967-08-21', 'Canada', 'Burnaby', 'https://ca-times.brightspotcdn.com/dims4/default/da35f5f/2147483647/strip/true/crop/3507x2330+0+0/resize/1200x797!/quality/75/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F06%2Fdb%2F0c13ce46483abda7e4ae99be7feb%2Fthe-acolyte-la-launch-'),
(12, 'Robert Downey Jr.', '1965-04-04', 'USA', 'New York', 'https://cdn.britannica.com/99/254199-050-98CF4E04/Robert-Downey-JR-UK-premier-Oppenheimer-movie-July-2023.jpg'),
(13, 'Chris Evans', '1981-06-13', 'USA', 'Boston', 'https://m.media-amazon.com/images/M/MV5BNzQ0YWM1ODEtZDFkYy00MGJhLTkwZDUtMzVkZjljODU3ZTRmXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg'),
(14, 'John Travolta', '1954-02-18', 'USA', 'Englewood', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0fpJu-VI7Wrl__Y4PnmiurnB2lrwKZO0-btHoXdaSH84aW1i9VLKGjO0pxLCdt-13a86dC38bFXuLSaMziJQg5g'),
(15, 'Samuel L. Jackson', '1948-12-21', 'USA', 'Washington D.C.', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcR3XfX1gQVoTOEnlVIRCnqLHWgsrvB7iAsZH2h69xP9rkOzCep1ES507vccTUtzH_neho4TOtKLeHWktOyXMlDWvQ'),
(16, 'Matthew Broderick', '1962-03-21', 'USA', 'New York', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTvXXLkUO_1muhhpqS4MVNAKNcDXj6_Imd8KcvZ0UhHv-6PREU3PY9l5_NzzjvD58K-s7gqhQXMohsYPNCa8HHyu8oojsZLE9V4iBJTdjc'),
(17, 'Idina Menzel', '1971-05-30', 'USA', 'Queens', 'https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/317808_v9_bb.jpg'),
(18, 'Hayao Miyazaki', '1941-01-05', 'Japan', 'Tokyo', 'https://images2.thanhnien.vn/528068263637045248/2023/9/24/hayao-miyazaki-1695548471560165622691.jpg'),
(19, 'Tim Robbins', '1958-10-16', 'USA', 'West Covina', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSVchFY6PGmPS7dAeO8E9Z4kMUGxahausdHBNt2CbOVGzcY0Y3DGYUZTGZLInI3u6iVbcOLlLROFLCpcU1wf1aWhw'),
(20, 'Marlon Brando', '1924-04-03', 'USA', 'Omaha', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQymfVtBXLtgtRuvuyoZsV2JRvBs02RieaJcHS1uj7miIGglDWW27MgYoCwTpdkj4H4XmU&usqp=CAU'),
(21, 'Al Pacino', '1940-04-25', 'USA', 'New York', 'https://pyxis.nymag.com/v1/imgs/bc9/ccb/936534d0b82b77cf0ffbac92010ee38ea3-06-al-pacino.2x.rvertical.w512.jpg'),
(22, 'Henry Fonda', '1905-05-16', 'USA', 'Grand Island', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Henry_Fonda_in_Warlock.jpg/1200px-Henry_Fonda_in_Warlock.jpg'),
(23, 'Tom Hanks', '1956-07-09', 'USA', 'Concord', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsQKIoh797hKmQ6GqnLsiz1pkCp3J_QPczfw8QGpvFYYtj4Gd8sL9fq0mETp2etJfErXKkUbTQIhf2DSX9ewmGvw'),
(24, 'Jodie Foster', '1962-11-19', 'USA', 'Los Angeles', 'https://m.media-amazon.com/images/M/MV5BMTM3MjgyOTQwNF5BMl5BanBnXkFtZTcwMDczMzEwNA@@._V1_FMjpg_UX1000_.jpg'),
(25, 'Anthony Hopkins', '1937-12-31', 'UK', 'Port Talbot', 'https://goldenglobes.com/wp-content/uploads/2023/10/anthony-hopkins-gettyimages-1188529965_0.jpg?w=1200'),
(26, 'Liam Neeson', '1952-06-07', 'Ireland', 'Ballymena', 'https://cdn.britannica.com/28/264528-050-18A03969/actor-liam-neeson-uk-premiere-of-marlowe-vue-west-end-march-16-2023-london-england.jpg'),
(27, 'Ralph Fiennes', '1962-12-22', 'UK', 'Ipswich', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Ralph_Fiennes_2024.jpg/800px-Ralph_Fiennes_2024.jpg'),
(28, 'Song Kang-ho', '1967-01-17', 'South Korea', 'Busan', 'https://d27csu38upkiqd.cloudfront.net/eyJidWNrZXQiOiJmZGMtc2l0ZXB1YmxpYy1tZWRpYS1wcm9kIiwia2V5IjoidXBsb2Fkc1wvMjAyM1wvMDNcLzEyMjU0NS5qcGciLCJlZGl0cyI6eyJyZXNpemUiOnsid2lkdGgiOjE2MDAsImZpdCI6ImNvdmVyIn19fQ=='),
(29, 'Choi Woo-shik', '1990-03-26', 'South Korea', 'Seoul', 'https://i.mydramalist.com/xWAE0_5f.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories_of_film`
--

CREATE TABLE `categories_of_film` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `categories_of_film`
--

INSERT INTO `categories_of_film` (`category_id`, `category_name`, `description`) VALUES
(1, 'Thriller', 'A genre of film that emphasizes suspense and tension.'),
(2, 'Drama', 'A genre of film that focuses on character development and emotional themes.'),
(3, 'Romance', 'A genre of film that centers on love stories.'),
(4, 'Sci-Fi', 'A genre of film that explores futuristic and speculative concepts.'),
(5, 'Action', 'High-paced movies with intense sequences of physical activity, including fights, chases, and explosions.'),
(6, 'Comedy', 'Light-hearted films designed to amuse and entertain with humor and satire.'),
(7, 'Horror', 'Movies that aim to frighten and evoke fear, often featuring supernatural or psychological themes.'),
(8, 'Adventure', 'Exciting films that follow characters on a journey or quest to explore new places and face challenges.'),
(9, 'Fantasy', 'Movies featuring magical or mythical elements, set in imaginative worlds.'),
(10, 'Documentary', 'Non-fiction films that provide a factual depiction of real-world events, people, or topics.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories_of_song`
--

CREATE TABLE `categories_of_song` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `categories_of_song`
--

INSERT INTO `categories_of_song` (`category_id`, `category_name`, `description`) VALUES
(1, 'Pop', 'A genre of music that is popular and catchy.'),
(2, 'Rock', 'A genre of music that features electric guitars and drums.'),
(3, 'Classical', 'A genre of music that is composed for orchestras and ensembles.'),
(4, 'Pop', 'Popular music genre'),
(5, 'Rock', 'Rock music genre'),
(6, 'Jazz', 'Jazz music genre'),
(7, 'R&B', 'Rhythm and Blues music genre'),
(8, 'Indie', 'Indie music genre'),
(9, 'Country', 'Country music genre'),
(10, 'V-Pop', 'Vietnamese Pop music genre'),
(11, 'US-UK Pop', 'US-UK Pop music genre'),
(12, 'K-Pop', 'Korean Pop music genre'),
(13, 'Ballad', 'Ballad music genre'),
(14, 'EDM', 'Electronic Dance Music genre'),
(15, 'Indo Pop', 'Indonesian Pop music genre'),
(16, 'Rap', 'A genre of music with rhythmic and rhyming speech'),
(17, 'Rap Melody', 'A blend of rap with melodic elements'),
(18, 'Lofi', 'Low-fidelity music with a relaxed vibe'),
(19, 'Radio', 'Broadcasted audio content'),
(20, 'Podcast', 'Audio programs or series on various topics');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comments`
--

CREATE TABLE `comments` (
  `comment_id` int(11) NOT NULL,
  `parent_comment_id` int(11) DEFAULT NULL,
  `comment_text` text NOT NULL,
  `time_rated` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `film_id` int(11) DEFAULT NULL,
  `song_id` int(11) DEFAULT NULL,
  `type` enum('song','film') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `comments`
--

INSERT INTO `comments` (`comment_id`, `parent_comment_id`, `comment_text`, `time_rated`, `user_id`, `film_id`, `song_id`, `type`) VALUES
(1, NULL, 'Amazing film! Must watch.', '2024-12-10 12:00:00', 1, 1, NULL, 'film'),
(2, NULL, 'The soundtrack is beautiful.', '2024-11-20 09:10:40', 2, NULL, 1, 'song'),
(4, 1, 'I agree', '2024-12-17 14:00:40', 3, 1, NULL, 'film'),
(5, NULL, 'That great', '2025-01-22 06:12:59', 1, 18, NULL, 'film');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `films`
--

CREATE TABLE `films` (
  `film_id` int(11) NOT NULL,
  `film_name` varchar(255) NOT NULL,
  `film_description` text DEFAULT NULL,
  `poster_img` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `release_date` date NOT NULL,
  `video` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `films`
--

INSERT INTO `films` (`film_id`, `film_name`, `film_description`, `poster_img`, `status`, `release_date`, `video`) VALUES
(1, 'Inception', 'DiCaprio plays Dom Cobb, a professional thief who performs economic espionage by penetrating the subconscious of his targets. Cobb is offered an impossible task to redeem his life: \"the original idea\" - through implanting one\'s own ideas into another\'s subconscious.', 'https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_FMjpg_UX1000_.jpg', 'In Progress', '2010-07-16', 'https://imdb-video.media-imdb.com/vi2959588889/1434659607842-pgv4ql-1596404706743.mp4?Expires=1734162992&Signature=AkR-O5efl0~3bqaW8UwnEgljTBeH9ENjNWvZ~fpavHJgIsK75zRdGWCbXwutkzU6gq5QF13b0oQZthiLI0m-HJd6xCmvkX4H4OyMVYjYY5oeGZKZdMNO8xqUE7QRxWR5sbXiE1kz-NGsoKNyhLTGBBFt~3U-zvaw6ZKBqSUxnumBWFPBO2phCZ8jMK6wpTk2g5aHcWBTydMIs0CLrbcz0Bz9-jlmV47iG9IbKwe922aC9MjER7KrDum30S2vFbwmNZNp01SEN0YbeKtNpPyxRZO3aWbhS6W43QLVIDIzZh5VRX5PcDezC4WGGKKoEINvX8OoDssjPUxZjjshExQvsg__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),
(2, 'The Dark Knight', 'In Gotham City , Mayor Borg orders District Attorney Harvey Dent and Police Commissioner James Gordon to arrest crime boss Carl Grissom. Meanwhile, reporters Alexander Knox and Vicki Vale investigate sightings of a masked hero nicknamed \" Batman \". The two attend a party hosted by billionaire Bruce Wayne. Bruce is Batman, who decided to become a crime-fighting hero after witnessing a robber shoot his parents to death when he was a child. Bruce has a crush on Vicki but leaves the party to follow Gordon.', 'https://m.media-amazon.com/images/M/MV5BMTIzMDc4MzA2Ml5BMl5BanBnXkFtZTcwODU0MzA3MQ@@._V1_FMjpg_UX1000_.jpg', 'Finished', '2008-07-18', 'https://imdb-video.media-imdb.com/vi324468761/1434659607842-pgv4ql-1563712918369.mp4?Expires=1734072305&Signature=IQmyUzAZ5LH0iO4Pv3LTIvVB-NvhnB0jQjcWtohHNWjoawnvTPajKmqqDdcipXhMlwziZXIL15J7yh4mJnIRXqGP1LFbbLfetgmUgSgdpLUJ2y2hOvyL5PnRY1MdL3A2byKZPGLK3GXmJT~EjsiUJMVNuuPUb8XnW5NBpx2lSgoQVrwv7adjapbFDJb6xViRicRcPKn9VnyEowPqoi-G6K40ICKoDYVGbVvoCEjaQwbFlWrpF~d8~JR6QCpxEolwEAwOxaD-KfxrqxHRFCyiQKgaeOEp2C1u~bxz8mV7Z6yie5i71VcoDO3TTHcCzh7WrBXRbpwwPS2~ZiBNZyc6bg__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),
(3, 'Titanic', 'In 1996, treasure hunter Brock Lovett and his team boarded the research vessel Akademik Mstislav Keldysh to the wreck of the legendary RMS Titanic in the Atlantic Ocean in search of a necklace with a very rare diamond, the Heart of the Ocean . They salvaged a safe, inside of which was a painting of a young nude woman wearing only the necklace. The painting was dated April 14, 1912, the day the Titanic hit the iceberg. After hearing the news on television, an elderly woman named Rose Dawson Calvert, who claimed to be the woman in the painting, visited Lovett and told him about her experiences on the Titanic .', 'https://m.media-amazon.com/images/M/MV5BYzYyN2FiZmUtYWYzMy00MzViLWJkZTMtOGY1ZjgzNWMwN2YxXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Tap 12', '1997-12-19', 'https://youtu.be/RDfwGkasp58?si=pThtW9GrlMn66YmW'),
(4, 'Interstellar', 'In 2067, a strange disease is killing crops , sandstorms are frequent, and the amount of oxygen in the atmosphere is decreasing, pushing humanity to the brink of extinction. Cooper, a widowed farmer who was formerly an engineer and NASA pilot , lives with his father-in-law Donald, his 15-year-old son Tom, and his 10-year-old daughter Murphy. Murphy believes that his room is haunted by a \"ghost\" that is trying to communicate with him. Murphy and Cooper discover that the \"ghost\" is an unknown form of intelligence, trying to send messages to him via gravitational waves , represented by strange dust trails that appear after the sandstorm. These messages, presented in binary code , reveal the coordinates of a secret NASA base, currently led by Professor Brand.', 'https://m.media-amazon.com/images/M/MV5BYzdjMDAxZGItMjI2My00ODA1LTlkNzItOWFjMDU5ZDJlYWY3XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Finished', '2014-11-07', 'https://imdb-video.media-imdb.com/vi1586278169/1434659607842-pgv4ql-1616202363366.mp4?Expires=1734163625&Signature=PWMAjYOOI0KNBd6qfqiBSlZP3~Zjp8rXhYx19~KsxodSybwG7GQnjBnYawah3nXPzngZy8WY0HMi0he6cU7KjNIEZ85sMBcqKXaPTt-xXnZNFaEqmeviwCbBK7w59F8ol2PTR0XSsfC4S9TkmufAztbiCybdr2jHpbyJ0PbFShmjF3~7f9bBe~EjX31oJYIX98EEvblZ8mVgQQtdXnw9bP1nb3WozLGBxnYqtg71i1I0DaElDs8lo-JWLdrJ9s7r~NgjhKNT~zZy1J2SKq3ldfWSQv~7OCjs9G4SgbiapH1LrMF2rhl1NLGFY5DaM1A-2AKphssKuGhOn5BP-AuAFA__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),
(5, 'One Piece', 'The story follows Monkey D. Luffy , a young man who, inspired by his childhood idol \"Red-Haired\" Shanks , sets out on a journey in the East Blue to find a treasure and become the Pirate King. During the formation of the Straw Hat Pirates , Luffy rescues and befriends a swordsman named Roronoa Zoro (ロのノア ゾロ), and together they begin their search for the One Piece. They are joined on their journey by Nami (ナミ), a navigator; Usopp (ウソプ), a marksman; Vinsmoke Sanji (ヴィンスモク サンジ), a chef. They obtain a ship called the Going Merry (ゴイング メリー) and confront the notorious pirate crews of East Blue. As Luffy and his crew begin their adventures, others join the crew later in the series, including Tony Tony Chopper (トニー チョパー), a doctor and talking reindeer; Nico Robin (ニコ ロビン), an archaeologist; Franky (フランキー), a cyborg shipwright; Brook (ブルーク), a musician, and Jinbei (ジンベイ), a fishman and former member of the Shichibukai (七武海). When the Going Merry is damaged beyond repair, the Straw Hat Pirates use a new ship called the Thousand Sunny (サウサンド サーニー). Together, they encounter pirates, bounty hunters, criminal organizations, revolutionaries, agents, and the World Government, among many other friends and enemies.', 'https://m.media-amazon.com/images/M/MV5BMTNjNGU4NTUtYmVjMy00YjRiLTkxMWUtNzZkMDNiYjZhNmViXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'In Progress', '1999-10-20', NULL),
(6, 'The Matrix', 'After a long search, Morpheus identified Thomas Anderson as \"The One\" or \"The Chosen One\", the outstanding individual who would end the war between the two factions. Thomas is a computer engineer and also a famous hacker known as \"Neo\", Neo is born and attached to the Matrix, he always has doubts about the world he lives in. Neo is led by Morpheus to escape the Matrix and reveals the ability to manipulate this virtual world, which further proves Morpheus\'s belief is correct. During a visit to Oracle (an excellent guessing program), Morpheus was captured by agents and interrogated about the code to open Zion (the underground city of humans, the closest to the Machine City). Neo risked his life to save Morpheus and destroyed Agent Smith, the high-level security program of the Matrix. Although shot dead by Smith, Neo was immediately revived after being kissed by Trinity, and their relationship began.', 'https://m.media-amazon.com/images/M/MV5BZWEzNzg2ZjktZTAzYy00Yzc5LTgzMWUtOGNmN2NhOWE3NmU1XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Finished', '1999-03-31', 'https://imdb-video.media-imdb.com/vi1032782617/1434659607842-pgv4ql-1606954147857.mp4?Expires=1734163748&Signature=UFHZvnETO2C4iC6IAK0VMTNqEbhUNg~xO-dHuhbX8v-dTjHJFCC1kZAcpLqDUkkttaLc1-1KMckrigEneludVgUHdP1blMpAC8slExCVN-1~Fr49t4uDtq0FxBiTa-FdJ4TC-JDFvF~M4tCLwr6ghEmBFf-96SD5B16he99KulSgUTy~ahITTDvU~kXb6G59jHoVMs4XODwPS60c5DjDoByBi49WYWlhFjAgnT1attfg10-1QiysbRWKmc-9JktSJGxskwX0I6C8VSF8k0KhZTPWTVOu6ilcC-9aULGr-ARkogI8ZPe9kBtoKShaGeHK~VlgvO-HAYaZvS9KK8i5Dw__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),
(7, 'Avengers: Endgame', 'The epic conclusion of the Marvel saga.', 'https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_FMjpg_UX1000_.jpg', 'Finished', '2019-04-26', 'https://imdb-video.media-imdb.com/vi2163260441/1434659607842-pgv4ql-1556354704370.mp4?Expires=1734163797&Signature=alp42fhL7RXFZoMh-1qpKmDZhsA~NB24Q0NVKQhkeLjRVIEuuC-~RM4cmuXIFJtYZgOpojk0Zx9vPyYF~PJnl2HzvqppGgRl~k0ZuskC3Lal3S6d4JuO4tmxMxNZ7w0-1f7dMJv2PXog1coAZEcwjV3XzgPqQOmiFySf8nUVctpOSdCuK0g5XdFVpCHSyMQgH6DQ3HOOMaHhSbR~kAVoEbt4efIutup8WVMPJ-Y9rAvwNI9G1XJNXXcUjlmrh6V8q-5laLHFNxsI6bBlNAqXJd7wOLxRWCfThS21iFQb32pcaRf3fdHiFX88YI5LUTxiegK6cO0u~saX-uI~mjmwmA__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),
(8, 'Pulp Fiction', 'Interwoven stories of crime and redemption.', 'https://m.media-amazon.com/images/M/MV5BYTViYTE3ZGQtNDBlMC00ZTAyLTkyODMtZGRiZDg0MjA2YThkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Finished', '1994-10-14', NULL),
(9, 'The Lion King', 'Mufasa, a cub lost and alone, meets a sympathetic lion named Taka, the heir to a royal bloodline. The chance meeting sets in motion an expansive journey of a group of misfits searching for their destiny. It is a live-action sequel to the 2019 film and the original 1994 film, The Lion King . [ 1 ] The film will feature Seth Rogen, Billy Eichner, and John Kani reprising their roles from the previous film , along with new appearances by Aaron Pierre and Kelvin Harrison Jr. , reprising their roles as a younger version of King Mufasa and his younger brother Scar , respectively.', 'https://m.media-amazon.com/images/M/MV5BZWVlMmExYzctNzlhMi00YWE5LTliOTMtM2UxMzhkNDFlNjhkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Finished', '1994-06-15', 'https://imdb-video.media-imdb.com/vi3953117465/1434659607842-pgv4ql-1732573687923.mp4?Expires=1734163873&Signature=PLOzWzg0VjvBRqFzJEEz4Ru9rgXrvmBf3-BEKWwV3oOC9-VDBxKN4-hwWu2rVl-790HrSyBgpMBTGdqjhVADV-NYugcpZKTzKo2o51lOV9qCdh6F7S5W3dI30fscYvYpBeQvmfTeh7sJH1~5Ou8mN6q1EPTpTp5hs58tdkGitdeoga8IZM-YKfvfx9cpDg1M-Q5i7QIl6Aygp3Hyo9uHbwCBPGJ8wcAc3yPkZoNNTiTB~L2nZf5Qc9zLx21DVHulpPioc3R7IdAL13C7mybLUZWWJDU~ru7Ctu-DCgwZvt25~JuOIbolkM6nOe5hSygwXUZ8jBqPnuxjev5xlsBb1A__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),
(10, 'Frozen', 'A magical journey of two sisters in Arendelle.', 'https://m.media-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_FMjpg_UX1000_.jpg', 'Finished', '2013-11-27', NULL),
(11, 'Spirited Away', 'During her family\'s move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches and spirits, and where humans are changed into beasts. While Chihiro\'s parents are eating at an empty restaurant, she finds a magnificent public bathhouse. She meets a young man, Haku, who advises her to return to the river before it gets dark. However, Chihiro discovers too late that her parents have been turned into pigs and she is unable to cross the river as the tide is rising, leaving her trapped in the spirit world.', 'https://m.media-amazon.com/images/M/MV5BNTEyNmEwOWUtYzkyOC00ZTQ4LTllZmUtMjk0Y2YwOGUzYjRiXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Finished', '2001-07-20', 'https://imdb-video.media-imdb.com/vi3619684633/1434659607842-pgv4ql-1564585734687.mp4?Expires=1734163682&Signature=D-8OxssbqII7spUR1Ivz~HwA6cZAYc77M9Hh~CzY3njQFc78MzNyYnUlHu7zPmvYfH4De68NbT-SZTlxRJimr~ZyE2eJygxjMcMIcpkAm7e-tb~ETIdlozt40kxqwhe55u1i7bJUX2Wj~wuD926yS8QmjV3C2MgGmXUq7i1dB1rUAzp0dhj5Z7IJQtTjN48~MdsILdg~YFot2QLXHB3rFERQBjUExLk1l8cp5ewO9kWS6MJf7NrD31ijDOmZm-nrTcyFmcKRxFhaGj6dKQRq0dZZSJ-BmYYPwd00SfB2aUdD1CwYdLXj25YoWmp9~qGzB~MjX~5vBIPsWIRP7kYzjA__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),
(12, 'The Shawshank Redemption', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 'https://m.media-amazon.com/images/M/MV5BMDAyY2FhYjctNDc5OS00MDNlLThiMGUtY2UxYWVkNGY2ZjljXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Finished', '1994-09-23', NULL),
(13, 'The Godfather', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 'https://m.media-amazon.com/images/M/MV5BYTJkNGQyZDgtZDQ0NC00MDM0LWEzZWQtYzUzZDEwMDljZWNjXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Finished', '1972-03-15', 'https://imdb-video.media-imdb.com/vi1348706585/1434659607842-pgv4ql-1616202346191.mp4?Expires=1734163921&Signature=Ophn6BZoAb1KvjKIXrtdIRRe3gvGOwdv6UKkYcu02TGY19PV24swZpncSI3mXJGV3iTHQ1evZv9Kc4q5HTTYXcbpH0DzF1Zae0kUEfEeCm9LXOfmet7CnerUNJVTsT1zxjJibPK0DH67co40zOCg80F5bJFPqC6CDa2hz04n~ztylRr8BJVij1gi1L1caO5comaSO7qpAeHAoXDfT6IaxcG1deNDM36NMeo3aNGJ-iwN6jOjHCAOHOvXYg05-fbjBbWwAdekE-to1c36tParoDBEKSh2Fnsu4xryRBhqWYltoHJ2xrmUnvpGyapUGmbXjY0Md6cMYgL9ITgjtJB~9g__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),
(14, '12 Angry Men', 'A jury foreman strives to ensure that a young man receives a fair trial.', 'https://m.media-amazon.com/images/M/MV5BYjE4NzdmOTYtYjc5Yi00YzBiLWEzNDEtNTgxZGQ2MWVkN2NiXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Finished', '1957-04-03', NULL),
(15, 'Forrest Gump', 'The life of Forrest Gump, a man with a low IQ but a good heart, who witnesses some of the major events of the 20th century.', 'https://upload.wikimedia.org/wikipedia/vi/thumb/1/1d/Forrest_gump.jpg/330px-Forrest_gump.jpg', 'Finished', '1994-07-06', NULL),
(16, 'The Silence of the Lambs', 'A young F.B.I. cadet must seek the help of a manipulative cannibalistic killer to catch another serial killer.', 'https://m.media-amazon.com/images/M/MV5BNDdhOGJhYzctYzYwZC00YmI2LWI0MjctYjg4ODdlMDExYjBlXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Finished', '1991-02-14', 'https://imdb-video.media-imdb.com/vi3377380121/1434659607842-pgv4ql-1537473620563.mp4?Expires=1734162856&Signature=Ef79gLEvzizB8WHDyXDp8EMTiZBJBzmsvu8LeuI0w3ew6nZmKGZx5gRoIXP7FMH6kdyMQN7Lga53P60tFALpHONUvQylqxA1oBkL~panGhAogOkkiQO8pLuHIQvj~gKrlSJohgFXM2EFUXXAXHbv3dVrGGsetPp81OBeHtw2fXJOKMmR2yuIZl7FDIk5dCUFBEs2Xw2Xv2JlytYB2N40QQprSjb77Mic3oYx3DhhvBcrtcpRZe5-tYugwNLG9Ag4MqSTgMwRH3UAIpBJ~efjc9-C-LTR-nxFFvzQDyE3x3cCAMINc0THkM6GxHo~-U17VmTE1CiPWBB2hygpUns0JA__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),
(17, 'Schindler\'s List', 'In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce as the Nazi regime intensifies.', 'https://m.media-amazon.com/images/M/MV5BNjM1ZDQxYWUtMzQyZS00MTE1LWJmZGYtNGUyNTdlYjM3ZmVmXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Finished', '1993-12-29', NULL),
(18, 'Parasite', 'The impoverished Kim family cunningly infiltrates the wealthy Park family by posing as unrelated, highly qualified individuals.', 'https://m.media-amazon.com/images/M/MV5BYTIzN2YwZDItYjdjNi00ZmU4LThiZTctMzJjYTlhY2YxMGI1XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'Finished', '2019-05-30', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `film_actor`
--

CREATE TABLE `film_actor` (
  `film_id` int(11) NOT NULL,
  `actor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `film_actor`
--

INSERT INTO `film_actor` (`film_id`, `actor_id`) VALUES
(1, 1),
(1, 6),
(2, 2),
(2, 4),
(3, 1),
(3, 3),
(4, 7),
(4, 8),
(5, 5),
(5, 9),
(6, 10),
(6, 11),
(7, 12),
(7, 13),
(8, 14),
(8, 15),
(9, 16),
(10, 17),
(11, 18),
(12, 19),
(13, 20),
(13, 21),
(14, 22),
(15, 23),
(16, 24),
(16, 25),
(17, 26),
(17, 27),
(18, 28),
(18, 29);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `film_category`
--

CREATE TABLE `film_category` (
  `film_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `film_category`
--

INSERT INTO `film_category` (`film_id`, `category_id`) VALUES
(1, 1),
(1, 4),
(2, 1),
(2, 4),
(2, 5),
(3, 2),
(3, 3),
(4, 1),
(4, 4),
(5, 4),
(5, 8),
(5, 9),
(6, 4),
(7, 4),
(7, 5),
(7, 9),
(8, 4),
(9, 8),
(9, 9),
(10, 3),
(10, 8),
(10, 9),
(11, 7),
(11, 8),
(11, 9),
(12, 2),
(13, 1),
(13, 2),
(14, 1),
(14, 2),
(15, 2),
(15, 6),
(16, 1),
(16, 7),
(17, 2),
(17, 10),
(18, 2),
(18, 4),
(18, 5),
(18, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `film_producer`
--

CREATE TABLE `film_producer` (
  `film_id` int(11) NOT NULL,
  `producer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `film_producer`
--

INSERT INTO `film_producer` (`film_id`, `producer_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(5, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `liked_films`
--

CREATE TABLE `liked_films` (
  `film_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `liked_films`
--

INSERT INTO `liked_films` (`film_id`, `user_id`) VALUES
(1, 1),
(3, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `liked_songs`
--

CREATE TABLE `liked_songs` (
  `song_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `liked_songs`
--

INSERT INTO `liked_songs` (`song_id`, `user_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `playlists`
--

CREATE TABLE `playlists` (
  `playlist_id` int(11) NOT NULL,
  `playlist_name` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `playlists`
--

INSERT INTO `playlists` (`playlist_id`, `playlist_name`, `user_id`) VALUES
(1, 'Romantic Hits', 1),
(2, 'Epic Soundtracks', 2),
(3, 'V-Pop', 1),
(4, 'Ai cũng phải bắt đầu từ đâu đó', 1),
(5, 'Lặng', 1),
(6, 'US-UK Pop', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `producers`
--

CREATE TABLE `producers` (
  `producer_id` int(11) NOT NULL,
  `producer_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `producers`
--

INSERT INTO `producers` (`producer_id`, `producer_name`) VALUES
(1, 'Christopher Nolan'),
(2, 'Emma Thomas'),
(3, 'James Cameron'),
(4, 'Oda Eiichiro');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `singers`
--

CREATE TABLE `singers` (
  `singer_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `date_of_birth` date NOT NULL,
  `country` varchar(255) NOT NULL,
  `singer_description` varchar(255) DEFAULT NULL,
  `avatar_img` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `singers`
--

INSERT INTO `singers` (`singer_id`, `name`, `date_of_birth`, `country`, `singer_description`, `avatar_img`) VALUES
(1, 'Celine Dion', '1968-03-30', 'Canada', 'Charlemagne', NULL),
(2, 'Hans Zimmer', '1957-09-27', 'Germany', 'Frankfurt', NULL),
(3, 'KHA', '1999-01-01', 'Vietnam', 'Musical Artist and Singer', 'https://yt3.googleusercontent.com/hr9f8NWYNnrG6bGNVzhw6GS3rJd_p0g150cNwdJ6oarkuuZvz9mjUeqlkApjaDT93Sk1xQNTEw=s160-c-k-c0x00ffffff-no-rj'),
(4, 'Giveon', '1994-02-21', 'United States', 'Musical Artist', 'https://www.rollingstone.com/wp-content/uploads/2021/03/giveon.jpg?w=1581&h=1054&crop=1'),
(5, 'Ali Gatie', '1997-05-31', 'Canada', 'Singer and Songwriter', 'https://i.scdn.co/image/ab6761610000e5eb528642fef307039a5358e3c0'),
(6, 'Keshi', '1994-06-20', 'United States', 'Singer and Songwriter, VietNamese', 'https://bookingagentinfo.com/wp-content/uploads/2024/03/ab6761610000e5ebd969cf117d0b0d4424bebdc5.jpg'),
(7, 'Lady Gaga', '1986-03-28', 'United States', 'Singer and Actress', 'https://hips.hearstapps.com/hmg-prod/images/lady-gaga-attends-the-64th-annual-grammy-awards-at-mgm-news-photo-1727455427.jpg?crop=1.00xw:0.667xh;0,0.0477xh&resize=640:*'),
(8, 'Bruno Mars', '1985-10-08', 'United States', 'Singer and Songwriter', 'https://yt3.googleusercontent.com/aqNdAvqqq69k4af_gfPdyw-UrP-K0sgXYpLPxpSLRA42bopt0iwUcMfdzYrsbaHZxWF5ld9cjA=s160-c-k-c0x00ffffff-no-rj'),
(9, 'JVKE', '2000-01-01', 'United States', 'Singer and Songwriter', 'https://yt3.googleusercontent.com/2nYOm33klbI2QkbKuZfdSdkF1Fzb3cIggFcxhyO3NUwtMtZl_TImTkzjuc_j0wVLEA1joC2pJw=s160-c-k-c0x00ffffff-no-rj'),
(10, 'Zack Tabudlo', '2001-01-01', 'Philippines', 'Singer and Songwriter', 'https://i.scdn.co/image/ab6761610000e5eb9b30ca8c188ff72b2182caf0'),
(11, 'Yuji', '1999-01-01', 'Indonesia', 'Singer and Songwriter', 'https://viberate-upload.ams3.cdn.digitaloceanspaces.com/prod/entity/artist/yuji-dAqvw'),
(12, 'Putri Dahlia', '1994-01-01', 'Indonesia', 'Singer', ''),
(13, 'Why Dont We', '2016-01-01', 'United States', 'Music Band with 5 singers', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTm8Ie7gdxg8On36jcpgOrbgI1nFIGjsWAiHw&s'),
(14, 'Dhruv', '1999-01-01', 'India', 'Singer and Songwriter', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBFoj9v1sqWMYQtIc4Dj1FyTffbF5vv46UKg&s'),
(15, 'Justin Bieber', '1994-03-01', 'Canada', 'Singer and Songwriter', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Justin_Bieber_in_2015.jpg/800px-Justin_Bieber_in_2015.jpg'),
(16, 'Ariana Grande', '1993-06-26', 'United States', 'Singer and Actress', 'https://upload.wikimedia.org/wikipedia/commons/9/93/Ariana_Grande_in_2020.jpg'),
(17, 'Billie Eilish', '2001-12-18', 'United States', 'Singer and Songwriter', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3OvcS9D4HfgBVOkvEY8mSQi59TmX8MVr7_A&s'),
(18, 'Ed Sheeran', '1991-02-17', 'United Kingdom', 'Singer and Songwriter', 'https://cdn.britannica.com/17/249617-050-4575AB4C/Ed-Sheeran-performs-Rockefeller-Plaza-Today-Show-New-York-2023.jpg'),
(19, 'KHA', '1999-01-01', 'Vietnam', 'Musical Artist and Singer', 'https://yt3.googleusercontent.com/hr9f8NWYNnrG6bGNVzhw6GS3rJd_p0g150cNwdJ6oarkuuZvz9mjUeqlkApjaDT93Sk1xQNTEw=s160-c-k-c0x00ffffff-no-rj'),
(20, 'Giveon', '1994-02-21', 'United States', 'Musical Artist', 'https://www.rollingstone.com/wp-content/uploads/2021/03/giveon.jpg?w=1581&h=1054&crop=1'),
(21, 'Ali Gatie', '1997-05-31', 'Canada', 'Singer and Songwriter', 'https://i.scdn.co/image/ab6761610000e5eb528642fef307039a5358e3c0'),
(22, 'Keshi', '1994-06-20', 'United States', 'Singer and Songwriter, VietNamese', 'https://bookingagentinfo.com/wp-content/uploads/2024/03/ab6761610000e5ebd969cf117d0b0d4424bebdc5.jpg'),
(23, 'Lady Gaga', '1986-03-28', 'United States', 'Singer and Actress', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Lady_Gaga_at_Joe_Biden%27s_inauguration_%28cropped_5%29.jpg/613px-Lady_Gaga_at_Joe_Biden%27s_inauguration_%28cropped_5%29.jpg'),
(24, 'Bruno Mars', '1985-10-08', 'United States', 'Singer and Songwriter', 'https://yt3.googleusercontent.com/aqNdAvqqq69k4af_gfPdyw-UrP-K0sgXYpLPxpSLRA42bopt0iwUcMfdzYrsbaHZxWF5ld9cjA=s160-c-k-c0x00ffffff-no-rj'),
(25, 'JVKE', '2000-01-01', 'United States', 'Singer and Songwriter', 'https://yt3.googleusercontent.com/2nYOm33klbI2QkbKuZfdSdkF1Fzb3cIggFcxhyO3NUwtMtZl_TImTkzjuc_j0wVLEA1joC2pJw=s160-c-k-c0x00ffffff-no-rj'),
(26, 'Zack Tabudlo', '2001-01-01', 'Philippines', 'Singer and Songwriter', 'https://i.scdn.co/image/ab6761610000e5eb9b30ca8c188ff72b2182caf0'),
(27, 'Yuji', '1999-01-01', 'Indonesia', 'Singer and Songwriter', 'https://viberate-upload.ams3.cdn.digitaloceanspaces.com/prod/entity/artist/yuji-dAqvw'),
(28, 'Putri Dahlia', '1994-01-01', 'Indonesia', 'Singer', ''),
(29, 'Why Dont We', '2016-01-01', 'United States', 'Music Band with 5 singers', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTm8Ie7gdxg8On36jcpgOrbgI1nFIGjsWAiHw&s'),
(30, 'Dhruv', '1999-01-01', 'India', 'Singer and Songwriter', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBFoj9v1sqWMYQtIc4Dj1FyTffbF5vv46UKg&s'),
(31, 'Justin Bieber', '1994-03-01', 'Canada', 'Singer and Songwriter', 'https://upload.wikimedia.org/wikipedia/commons/2/25/Justin_Bieber_in_2019.jpg'),
(32, 'Ariana Grande', '1993-06-26', 'United States', 'Singer and Actress', 'https://upload.wikimedia.org/wikipedia/commons/9/93/Ariana_Grande_in_2020.jpg'),
(33, 'Billie Eilish', '2001-12-18', 'United States', 'Singer and Songwriter', 'https://upload.wikimedia.org/wikipedia/commons/1/1f/Billie_Eilish_2019_by_Glenn_Francis.jpg'),
(34, 'Ed Sheeran', '1991-02-17', 'United Kingdom', 'Singer and Songwriter', 'https://upload.wikimedia.org/wikipedia/commons/5/51/Ed_Sheeran-6886_%28cropped%29.jpg'),
(35, 'Lee Sun Hee', '1964-11-11', 'South Korea', 'Singer and Songwriter', ''),
(36, 'James Arthur', '1988-03-02', 'United Kingdom', 'Singer and Songwriter', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/James_Arthur-6645_%28cropped%29.jpg/800px-James_Arthur-6645_%28cropped%29.jpg'),
(37, 'One Direction', '2010-07-23', 'United Kingdom', 'Music Band with 5 singers', 'https://yt3.ggpht.com/ytc/AIdro_lBZumWLg8HqCIAD4oHGTIIdD8DTz5eV_DgCXFu6KxNjj28=s176-c-k-c0x00ffffff-no-rj'),
(38, 'RPT MCK', '2000-01-01', 'Vietnam', 'Vietnamese rapper and singer', 'https://i.vietgiaitri.com/2024/11/6/mck-lam-gi-khi-lo-anh-nhay-cam-56b-7310499.webp'),
(39, 'Khalid', '1998-02-11', 'USA', 'American singer-songwriter', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0DDhUmdQhDiRznWwv6fBRciVrG1Ry8_A31g&s'),
(40, 'Charlie Puth', '1991-12-02', 'USA', 'American pop singer', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0WtZR3kHypbTGK5zOQfwi2i_l_2yiJONoNA&s'),
(41, 'GUrbane', '2000-02-24', 'Vietnam', 'young artist or producer', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQy3rOcJ15lK1Br6wVrCgIu18Ars4rA549eIA&s'),
(42, 'HIEUTHUHAI', '1999-10-22', 'Vietnam', 'Vietnamese rapper and songwriter', 'https://i.scdn.co/image/ab6761610000e5ebe1cbc9e7ba8fbc5d7738ea51'),
(43, 'Shiki', '2002-12-02', 'Vietnam', 'Composer - singer', 'https://i.scdn.co/image/ab6761610000517471581ba96c0dfa03f23beeb9');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `songs`
--

CREATE TABLE `songs` (
  `song_id` int(11) NOT NULL,
  `song_name` varchar(255) NOT NULL,
  `song_description` text DEFAULT NULL,
  `release_date` date NOT NULL,
  `poster_img` varchar(255) DEFAULT NULL,
  `audio_link` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `songs`
--

INSERT INTO `songs` (`song_id`, `song_name`, `song_description`, `release_date`, `poster_img`, `audio_link`) VALUES
(1, 'One of your girls', 'The iconic love theme from Titanic.', '2024-12-19', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTO7pQYJTj5gcV9BMVpyQVcXaT2j7tE8a6jfQ&s', 'The Weeknd, JENNIE & Lily Rose Depp - One Of The Girls (Official Audio).mp3'),
(2, 'Mất Kết Nối', 'Trendy viet pop', '2024-07-16', 'https://i.ytimg.com/vi/lRsaDQtYqAo/maxresdefault.jpg', 'LostConnection.mp3'),
(11, 'Its you', 'Its you is a song by Ali Gatie', '2022-03-25', 'https://i.ytimg.com/vi/PXGycbkbtW0/maxresdefault.jpg', 'ItsYou.mp3'),
(12, 'Old love', 'Popular Indonesia song', '2019-08-10', 'https://c-fa.cdn.smule.com/smule-gg-uw1-s-5/arr/75/f8/4f3acb66-b43b-4e13-9443-95a091410b70.jpg', 'OldLove.mp3'),
(13, 'Double take', 'Double take is a song by Dhruv', '2022-03-25', 'https://i.scdn.co/image/ab67616d0000b273834f16100678d3e800fb5fb9', 'doubletake.mp3'),
(14, '8 Letters', '8 Letters is a song by Why Dont We', '2018-08-31', 'https://i.scdn.co/image/ab67616d0000b273b503cdb444b28826c4ca9217', '8letters.mp3'),
(15, 'Golden Hour', 'Hottest songs ever in 2022', '2022-02-22', 'https://i.scdn.co/image/ab67616d0000b27360923c276b51ec96ec8f781d', 'golden hour.mp3'),
(16, 'Pano', 'Pano is a song by Zack Tabudlo', '2022-03-25', 'https://i1.sndcdn.com/artworks-s00IffaMkbws-0-t500x500.jpg', 'Pano.mp3'),
(17, 'HeartBreak Anniversary', 'Sad song about love', '2017-07-23', 'https://upload.wikimedia.org/wikipedia/en/2/2a/Giveon_-_Heartbreak_Anniversary.png', 'HeartbreakAnniversary.mp3'),
(18, 'Die with a smile', 'Die with a smile is a song by Bruno Mars', '2022-03-25', 'https://is1-ssl.mzstatic.com/image/thumb/Music221/v4/11/ae/f2/11aef294-f57c-bab9-c9fc-529162984e62/24UMGIM85348.rgb.jpg/1200x1200bb.jpg', 'DieWithASmile.mp3'),
(19, 'Limbo', 'Limbo is a song by Keshi', '2022-03-25', 'https://i.ytimg.com/vi/8xCxo6yTk3o/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLATjf-Amm4mfmpEpBKEa8zxRISRzg', 'LIMBO.mp3'),
(20, 'Its you', 'Its you is a song by Ali Gatie', '2022-03-25', 'https://i.ytimg.com/vi/PXGycbkbtW0/maxresdefault.jpg', 'ItsYou.mp3'),
(21, 'Car\'s Outside', 'A story about long-distance love', '2022-03-25', 'https://i.scdn.co/image/ab67616d0000b273bde319f49b9079c727c46410', 'CarsOutSide.mp3'),
(22, 'Đoạn đường sao băng', 'Chill song which can make you fall in love', '2022-03-25', 'https://photo-resize-zmp3.zadn.vn/w600_r1x1_jpeg/cover/1/e/f/c/1efc23399a2ecb20bc5d9cbcf1654232.jpg', 'DoanDuongSaoBang.mp3'),
(23, 'Love yourself', 'Love yourself is a song by Justin Bieber', '2015-11-09', 'https://m.media-amazon.com/images/I/61xsK0s4pNL._AC_UF1000,1000_QL80_.jpg', 'LoveYourSelf.mp3'),
(24, 'Stay', 'Stay is a song by Justin Bieber', '2021-07-09', 'https://upload.wikimedia.org/wikipedia/vi/1/1e/Poster_b%C3%A0i_h%C3%A1t_%22Stay%22.png', 'Stay.mp3'),
(25, 'Shivers', 'Shivers is a song by Ed Sheeran', '2021-09-10', 'https://i1.sndcdn.com/artworks-ftKzlYNpV2XrpeUL-XMcGVQ-t500x500.jpg', 'Shivers.mp3'),
(26, 'Photograph', 'Photograph is a song by Ed Sheeran', '2014-06-20', 'https://i1.sndcdn.com/artworks-000124348046-qeyff7-t500x500.jpg', 'Photograph.mp3'),
(28, 'Beside you', 'Beside you is a song by 5 Seconds of Summer', '2014-06-27', 'https://i.ytimg.com/vi/aMyO6GNkfpo/maxresdefault.jpg', 'BesideYou.mp3'),
(29, 'Fox Rain', 'Fox Rain is a song by Lee Sun Hee', '2012-03-14', 'https://avatar-ex-swe.nixcdn.com/song/2023/03/21/5/5/b/2/1679393098670_640.jpg', 'FoxRain.mp3'),
(30, 'Anh Đã Ổn Hơn', 'Song by RPT MCK', '2023-01-01', 'https://i1.sndcdn.com/artworks-PXjy5sywELqCfvhr-LVK2bA-t500x500.jpg', '14. Anh Đã Ổn Hơn - RPT MCK    99%  the album.mp3'),
(31, 'Lovely', 'Song by Billie Eilish and Khalid', '2022-12-10', 'https://i1.sndcdn.com/artworks-000344377479-prcevs-t500x500.jpg', 'Billie Eilish, Khalid - lovely.mp3'),
(32, 'Cheating on You', 'Song by Charlie Puth', '2021-05-15', 'https://i1.sndcdn.com/artworks-000606602386-58veao-t500x500.jpg', 'CheatingOnYou.mp3'),
(33, 'Light Switch', 'Song by Charlie Puth', '2022-01-20', 'https://i1.sndcdn.com/artworks-2FFAOv9bSZnlJ7rS-QwgJVw-t240x240.jpg', 'LightSwitch.mp3'),
(34, 'DaKey', 'Instrumental or song', '2023-02-01', 'https://i1.sndcdn.com/artworks-i4iuSTEbgLvaMnKD-1XM8pA-t500x500.jpg', 'DaKey.mp3'),
(35, 'Exit Sign', 'Song by HIEUTHUHAI (prod. by Kewtiie) ft. marzuz', '2023-03-25', 'https://images.genius.com/5dfc540042bb79770d1e3eed9e482b40.1000x1000x1.jpg', 'HIEUTHUHAI - Exit Sign (prod. by Kewtiie) ft. marzuz.mp3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `song_category`
--

CREATE TABLE `song_category` (
  `song_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `song_category`
--

INSERT INTO `song_category` (`song_id`, `category_id`) VALUES
(1, 1),
(1, 7),
(2, 1),
(2, 10),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 8),
(10, 1),
(11, 7),
(12, 1),
(12, 12),
(13, 1),
(13, 2),
(14, 1),
(14, 3),
(15, 1),
(15, 4),
(15, 11),
(16, 1),
(16, 5),
(16, 12),
(17, 1),
(17, 6),
(17, 10),
(18, 1),
(18, 10),
(19, 1),
(19, 10),
(20, 1),
(20, 9),
(20, 10),
(21, 1),
(22, 1),
(23, 1),
(23, 12),
(24, 1),
(25, 1),
(26, 4),
(26, 10),
(28, 10),
(29, 11),
(30, 1),
(30, 10),
(30, 12),
(31, 11),
(31, 13),
(32, 7),
(32, 11),
(33, 7),
(33, 11),
(34, 2),
(34, 9),
(35, 1),
(35, 10),
(35, 12);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `song_playlist`
--

CREATE TABLE `song_playlist` (
  `song_id` int(11) NOT NULL,
  `playlist_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `song_playlist`
--

INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3),
(11, 2),
(15, 2),
(22, 3),
(30, 3),
(34, 3),
(35, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `song_singer`
--

CREATE TABLE `song_singer` (
  `song_id` int(11) NOT NULL,
  `singer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `song_singer`
--

INSERT INTO `song_singer` (`song_id`, `singer_id`) VALUES
(1, 1),
(2, 2),
(3, 12),
(4, 13),
(5, 7),
(6, 8),
(7, 6),
(8, 5),
(8, 11),
(9, 4),
(10, 3),
(11, 5),
(12, 11),
(12, 12),
(13, 14),
(14, 13),
(15, 9),
(16, 10),
(17, 4),
(18, 7),
(18, 8),
(19, 6),
(20, 5),
(21, 36),
(22, 3),
(23, 15),
(24, 15),
(25, 18),
(26, 34),
(28, 6),
(29, 35),
(30, 37),
(31, 17),
(31, 39),
(32, 40),
(33, 40),
(34, 41),
(35, 42);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `star_rated`
--

CREATE TABLE `star_rated` (
  `star_rated_id` int(11) NOT NULL,
  `star_number` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `song_id` int(11) DEFAULT NULL,
  `film_id` int(11) DEFAULT NULL,
  `type` enum('song','film') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `star_rated`
--

INSERT INTO `star_rated` (`star_rated_id`, `star_number`, `user_id`, `song_id`, `film_id`, `type`) VALUES
(1, 5, 1, NULL, 1, 'film'),
(2, 5, 2, NULL, 3, 'film'),
(3, 4, 1, 1, NULL, 'song'),
(4, 3, 1, NULL, 8, 'film'),
(5, 4, 1, NULL, 18, 'film'),
(6, 3, 1, NULL, 17, 'film'),
(7, 2, 1, NULL, 11, 'film'),
(8, 5, 1, NULL, 7, 'film'),
(9, 4, 1, NULL, 2, 'film');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `date_of_birth` date NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `Role` enum('admin','user') NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `avatar_img` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`user_id`, `name`, `date_of_birth`, `username`, `password`, `Role`, `email`, `avatar_img`) VALUES
(1, 'Nguyen Van Minh', '1990-01-15', 'minhnvm2307', '123456', 'admin', 'nguyenvancanh197309@gmail.com', 'https://cdn1.iconfinder.com/data/icons/user-pictures/101/malecostume-512.png'),
(2, 'John Doe', '1990-01-15', 'johndoe', 'password123', 'user', NULL, 'https://cdn4.iconfinder.com/data/icons/man-6/48/man-06-512.png'),
(3, 'Jane Smith', '1985-07-23', 'janesmith', 'password456', 'user', NULL, 'https://cdn1.iconfinder.com/data/icons/simple-avatar-set/512/Chr_1-512.png'),
(4, 'Luong Khanh Linh', '2005-06-02', 'linhluongkhanh', 'yeuminh', 'user', 'linhluongkhanh0206@gmail.com', 'https://cdn1.iconfinder.com/data/icons/simple-avatar-set/512/Chr_4-512.png');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `actors`
--
ALTER TABLE `actors`
  ADD PRIMARY KEY (`actor_id`);

--
-- Chỉ mục cho bảng `categories_of_film`
--
ALTER TABLE `categories_of_film`
  ADD PRIMARY KEY (`category_id`);

--
-- Chỉ mục cho bảng `categories_of_song`
--
ALTER TABLE `categories_of_song`
  ADD PRIMARY KEY (`category_id`);

--
-- Chỉ mục cho bảng `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `film_id` (`film_id`),
  ADD KEY `song_id` (`song_id`);

--
-- Chỉ mục cho bảng `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`film_id`);

--
-- Chỉ mục cho bảng `film_actor`
--
ALTER TABLE `film_actor`
  ADD PRIMARY KEY (`film_id`,`actor_id`),
  ADD KEY `actor_id` (`actor_id`);

--
-- Chỉ mục cho bảng `film_category`
--
ALTER TABLE `film_category`
  ADD PRIMARY KEY (`film_id`,`category_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Chỉ mục cho bảng `film_producer`
--
ALTER TABLE `film_producer`
  ADD PRIMARY KEY (`film_id`,`producer_id`),
  ADD KEY `producer_id` (`producer_id`);

--
-- Chỉ mục cho bảng `liked_films`
--
ALTER TABLE `liked_films`
  ADD PRIMARY KEY (`film_id`,`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `liked_songs`
--
ALTER TABLE `liked_songs`
  ADD PRIMARY KEY (`song_id`,`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `playlists`
--
ALTER TABLE `playlists`
  ADD PRIMARY KEY (`playlist_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `producers`
--
ALTER TABLE `producers`
  ADD PRIMARY KEY (`producer_id`);

--
-- Chỉ mục cho bảng `singers`
--
ALTER TABLE `singers`
  ADD PRIMARY KEY (`singer_id`);

--
-- Chỉ mục cho bảng `songs`
--
ALTER TABLE `songs`
  ADD PRIMARY KEY (`song_id`);

--
-- Chỉ mục cho bảng `song_category`
--
ALTER TABLE `song_category`
  ADD PRIMARY KEY (`song_id`,`category_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Chỉ mục cho bảng `song_playlist`
--
ALTER TABLE `song_playlist`
  ADD PRIMARY KEY (`song_id`,`playlist_id`),
  ADD KEY `playlist_id` (`playlist_id`);

--
-- Chỉ mục cho bảng `song_singer`
--
ALTER TABLE `song_singer`
  ADD PRIMARY KEY (`song_id`,`singer_id`),
  ADD KEY `singer_id` (`singer_id`);

--
-- Chỉ mục cho bảng `star_rated`
--
ALTER TABLE `star_rated`
  ADD PRIMARY KEY (`star_rated_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `song_id` (`song_id`),
  ADD KEY `film_id` (`film_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `actors`
--
ALTER TABLE `actors`
  MODIFY `actor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT cho bảng `categories_of_film`
--
ALTER TABLE `categories_of_film`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `categories_of_song`
--
ALTER TABLE `categories_of_song`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `comments`
--
ALTER TABLE `comments`
  MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `films`
--
ALTER TABLE `films`
  MODIFY `film_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `playlists`
--
ALTER TABLE `playlists`
  MODIFY `playlist_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `producers`
--
ALTER TABLE `producers`
  MODIFY `producer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `singers`
--
ALTER TABLE `singers`
  MODIFY `singer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT cho bảng `songs`
--
ALTER TABLE `songs`
  MODIFY `song_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT cho bảng `star_rated`
--
ALTER TABLE `star_rated`
  MODIFY `star_rated_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`),
  ADD CONSTRAINT `comments_ibfk_3` FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`);

--
-- Các ràng buộc cho bảng `film_actor`
--
ALTER TABLE `film_actor`
  ADD CONSTRAINT `film_actor_fk` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `film_actor_ibfk_1` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`),
  ADD CONSTRAINT `film_actor_ibfk_2` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`actor_id`);

--
-- Các ràng buộc cho bảng `film_category`
--
ALTER TABLE `film_category`
  ADD CONSTRAINT `film_category_fk` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `film_category_ibfk_1` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`),
  ADD CONSTRAINT `film_category_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories_of_film` (`category_id`);

--
-- Các ràng buộc cho bảng `film_producer`
--
ALTER TABLE `film_producer`
  ADD CONSTRAINT `film_producer_fk` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `film_producer_ibfk_1` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`),
  ADD CONSTRAINT `film_producer_ibfk_2` FOREIGN KEY (`producer_id`) REFERENCES `producers` (`producer_id`);

--
-- Các ràng buộc cho bảng `liked_films`
--
ALTER TABLE `liked_films`
  ADD CONSTRAINT `liked_films_ibfk_1` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`),
  ADD CONSTRAINT `liked_films_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Các ràng buộc cho bảng `liked_songs`
--
ALTER TABLE `liked_songs`
  ADD CONSTRAINT `liked_songs_ibfk_1` FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`),
  ADD CONSTRAINT `liked_songs_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Các ràng buộc cho bảng `playlists`
--
ALTER TABLE `playlists`
  ADD CONSTRAINT `playlists_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Các ràng buộc cho bảng `song_category`
--
ALTER TABLE `song_category`
  ADD CONSTRAINT `song_category_fk` FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `song_category_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories_of_song` (`category_id`);

--
-- Các ràng buộc cho bảng `song_playlist`
--
ALTER TABLE `song_playlist`
  ADD CONSTRAINT `song_playlist_fk` FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `song_playlist_ibfk_1` FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`),
  ADD CONSTRAINT `song_playlist_ibfk_2` FOREIGN KEY (`playlist_id`) REFERENCES `playlists` (`playlist_id`);

--
-- Các ràng buộc cho bảng `song_singer`
--
ALTER TABLE `song_singer`
  ADD CONSTRAINT `song_singer_fk` FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `song_singer_ibfk_1` FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`),
  ADD CONSTRAINT `song_singer_ibfk_2` FOREIGN KEY (`singer_id`) REFERENCES `singers` (`singer_id`);

--
-- Các ràng buộc cho bảng `star_rated`
--
ALTER TABLE `star_rated`
  ADD CONSTRAINT `star_rated_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `star_rated_ibfk_2` FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`),
  ADD CONSTRAINT `star_rated_ibfk_3` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
