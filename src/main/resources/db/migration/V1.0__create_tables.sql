CREATE TABLE [tVideo](
VideoID int IDENTITY(1,1) PRIMARY KEY,
YouTubeVideoID varchar(255) NOT NULL,
VideoTitle varchar(255) NOT NULL,
VideoDescription varchar(1000),
PublishedDate DATETIME NOT NULL,
YoutubeChannelID varchar(255) NOT NULL,
ChannelTitle varchar(255) NOT NULL,
DefaultThumbnailURL varchar(255),
MediumThumbnailURL varchar(255),
HighThumbnailURL varchar(255),
)
GO

--CREATE TABLE [tChannel](
--ChannelID int IDENTITY(0,1) PRIMARY KEY,
--YoutubeChannelID varchar(255) NOT NULL,
--ChannelTitle varchar(255) NOT NULL
--)
--GO
--
--CREATE TABLE [tVideo](
--VideoID int IDENTITY(0,1) PRIMARY KEY,
--YouTubeVideoID varchar(255) NOT NULL,
--VideoTitle varchar(255) NOT NULL,
--VideoDescription varchar(1000),
--PublishedDate DATETIME NOT NULL,
--ChannelID int NOT NULL
--CONSTRAINT FK_Channel FOREIGN KEY (ChannelID) REFERENCES tChannel(ChannelID)
--)
--GO
--
--CREATE TABLE [tThumbnail](
--ThumbnailID int IDENTITY(0,1) PRIMARY KEY,
--DefaultURL varchar(255),
--MediumURL varchar(255),
--HighURL varchar(255)
--)
--GO
--
--CREATE TABLE [tVideoToThumbnailMap](
--VideoToThumbnailMapID int IDENTITY(0,1) PRIMARY KEY,
--VideoID int,
--ThumbnailID int
--CONSTRAINT FK_Video FOREIGN KEY (VideoID) REFERENCES tVideo(VideoID),
--CONSTRAINT FK_Thumbnail FOREIGN KEY (ThumbnailID) REFERENCES tThumbnail(ThumbnailID)
--)
--GO