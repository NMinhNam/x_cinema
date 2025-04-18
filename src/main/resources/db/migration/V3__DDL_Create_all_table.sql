CREATE TABLE Cinema
(
    CinemaId    UUID         NOT NULL PRIMARY KEY,
    Name        VARCHAR(255) NOT NULL,
    Address     VARCHAR(255),
    City        VARCHAR(100),
    PhoneNumber VARCHAR(20),
    Email       VARCHAR(255) UNIQUE
);

CREATE TABLE Genre
(
    GenreId     UUID         NOT NULL PRIMARY KEY,
    GenreName   VARCHAR(100) NOT NULL,
    Description TEXT
);

CREATE TABLE Movie
(
    MovieId     UUID         NOT NULL PRIMARY KEY,
    Title       VARCHAR(255) NOT NULL,
    Description TEXT,
    Duration    INT CHECK (Duration > 0),
    ReleaseDate DATE,
    Language    VARCHAR(50),
    MovieRate   VARCHAR(10),
    GenreId     UUID         NOT NULL,
    Director    VARCHAR(255),
    Actor       TEXT,
    FOREIGN KEY (GenreId) REFERENCES Genre (GenreId)
);

CREATE TABLE Room
(
    RoomId     UUID         NOT NULL PRIMARY KEY,
    CinemaId   UUID         NOT NULL,
    RoomName   VARCHAR(100) NOT NULL,
    RoomType   VARCHAR(50),
    TotalSeats INT CHECK (TotalSeats > 0),
    Surcharge  DECIMAL(10, 2) DEFAULT 0.00,
    FOREIGN KEY (CinemaId) REFERENCES Cinema (CinemaId)
);

CREATE TABLE Showtime
(
    ShowtimeId UUID                     NOT NULL PRIMARY KEY,
    MovieId    UUID                     NOT NULL,
    RoomId     UUID                     NOT NULL,
    BasePrice  DECIMAL(10, 2) CHECK (BasePrice >= 0),
    StartTime  TIMESTAMP WITH TIME ZONE NOT NULL,
    EndTime    TIMESTAMP WITH TIME ZONE NOT NULL,
    FOREIGN KEY (MovieId) REFERENCES Movie (MovieId),
    FOREIGN KEY (RoomId) REFERENCES Room (RoomId)
);

CREATE TABLE Seat
(
    SeatId       UUID NOT NULL PRIMARY KEY,
    RoomId       UUID NOT NULL,
    Position     VARCHAR(10),
    RowAlphabet  CHAR(1),
    ColumnNumber INT,
    SeatType     VARCHAR(50),
    Status       VARCHAR(20) CHECK (Status IN ('Available', 'Reserved', 'Booked')),
    Surcharge    DECIMAL(10, 2) DEFAULT 0.00,
    FOREIGN KEY (RoomId) REFERENCES Room (RoomId)
);

CREATE TABLE users
(
    UserId      UUID         NOT NULL PRIMARY KEY,
    Username    VARCHAR(255) NOT NULL UNIQUE,
    Password    VARCHAR(255) NOT NULL,
    Fullname    VARCHAR(255),
    Email       VARCHAR(255) UNIQUE,
    PhoneNumber VARCHAR(20),
    DateOfBirth DATE,
    Gender      VARCHAR(10) CHECK (Gender IN ('Male', 'Female', 'Other')),
    Role        VARCHAR(50) DEFAULT 'Customer',
    Status      VARCHAR(20) CHECK (Status IN ('Active', 'Inactive'))
);

CREATE TABLE Notification
(
    NotificationId UUID         NOT NULL PRIMARY KEY,
    UserId         UUID         NOT NULL,
    Title          VARCHAR(255) NOT NULL,
    Content        TEXT,
    IsRead         BOOLEAN                  DEFAULT FALSE,
    SentAt         TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserId) REFERENCES "User" (UserId)
);

CREATE TABLE Review
(
    ReviewId  UUID NOT NULL PRIMARY KEY,
    UserId    UUID NOT NULL,
    MovieId   UUID NOT NULL,
    Rating    INT CHECK (Rating >= 1 AND Rating <= 5),
    Comment   TEXT,
    CreatedAt TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserId) REFERENCES "User" (UserId),
    FOREIGN KEY (MovieId) REFERENCES Movie (MovieId)
);

CREATE TABLE Voucher
(
    VoucherId         UUID        NOT NULL PRIMARY KEY,
    VoucherCode       VARCHAR(50) NOT NULL UNIQUE,
    DiscountPercent   DECIMAL(5, 2) CHECK (DiscountPercent >= 0 AND DiscountPercent <= 100),
    ExpiryDate        DATE        NOT NULL,
    MinOrderAmount    DECIMAL(10, 2) CHECK (MinOrderAmount >= 0),
    MaxDiscountAmount DECIMAL(10, 2) CHECK (MaxDiscountAmount >= 0),
    IsActive          BOOLEAN DEFAULT TRUE
);

CREATE TABLE Booking
(
    BookingId   UUID NOT NULL PRIMARY KEY,
    UserId      UUID NOT NULL,
    ShowtimeId  UUID NOT NULL,
    BookingDate TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    TotalAmount DECIMAL(10, 2) CHECK (TotalAmount >= 0),
    VoucherId   UUID,
    Status      VARCHAR(20) CHECK (Status IN ('Pending', 'Confirmed', 'Cancelled')),
    FOREIGN KEY (UserId) REFERENCES "User" (UserId),
    FOREIGN KEY (ShowtimeId) REFERENCES Showtime (ShowtimeId),
    FOREIGN KEY (VoucherId) REFERENCES Voucher (VoucherId)
);

CREATE TABLE Booking_Seat
(
    BookingId UUID NOT NULL,
    SeatId    UUID NOT NULL,
    Price     DECIMAL(10, 2) CHECK (Price >= 0),
    Status    VARCHAR(20) CHECK (Status IN ('Pending', 'Confirmed', 'Cancelled')),
    IssuedAt  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (BookingId, SeatId),
    FOREIGN KEY (BookingId) REFERENCES Booking (BookingId),
    FOREIGN KEY (SeatId) REFERENCES Seat (SeatId)
);

CREATE TABLE Payment
(
    PaymentId     UUID        NOT NULL PRIMARY KEY,
    BookingId     UUID        NOT NULL,
    Amount        DECIMAL(10, 2) CHECK (Amount >= 0),
    PaymentMethod VARCHAR(50) NOT NULL,
    TransactionId VARCHAR(255),
    Status        VARCHAR(20) CHECK (Status IN ('Pending', 'Completed', 'Failed', 'Refunded')),
    FOREIGN KEY (BookingId) REFERENCES Booking (BookingId)
);

-- Indexes for performance
CREATE INDEX idx_movie_title ON Movie (Title);
CREATE INDEX idx_showtime_starttime ON Showtime (StartTime);
CREATE INDEX idx_user_username ON "User" (Username);
CREATE INDEX idx_booking_userid ON Booking (UserId);
CREATE INDEX idx_notification_userid ON Notification (UserId);