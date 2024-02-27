USE [my-fap]
GO
/****** Object:  Table [dbo].[M_Major]    Script Date: 2/9/2024 2:55:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_Major](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Name] [nvarchar](100) NOT NULL,
    [Category] [nvarchar](100) NOT NULL,
    [DegreeLevel] [varchar](100) NOT NULL,
    [FullName] [nvarchar](150) NOT NULL,
    [Description] [nvarchar](max) NOT NULL,
    [IsActive] [bit] NOT NULL,
    CONSTRAINT [PK_M_Major] PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[M_SubMajor]    Script Date: 2/9/2024 2:55:21 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[M_SubMajor](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Name] [nvarchar](200) NOT NULL,
    [FullName] [nvarchar](200) NOT NULL,
    [MajorId] [int] NOT NULL,
    [Type] [nvarchar](150) NULL,
    [Description] [nvarchar](max) NOT NULL,
    [IsCommon] [bit] NOT NULL,
    [IsActive] [bit] NOT NULL,
    CONSTRAINT [PK_M_SubMajor] PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[S_Role]    Script Date: 2/9/2024 2:55:21 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[S_Role](
    [id] [int] NOT NULL,
    [name] [nvarchar](50) NOT NULL,
    CONSTRAINT [PK_S_Role] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[S_User]    Script Date: 2/9/2024 2:55:21 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[S_User](
    [UserId] [int] IDENTITY(1,1) NOT NULL,
    [UserName] [varchar](50) NOT NULL,
    [UserPassword] [varchar](max) NOT NULL,
    [Phone] [varchar](50) NULL,
    [Mail] [varchar](50) NULL,
    [Address] [nvarchar](100) NULL,
    [LastLogin] [date] NULL,
    [IsActive] [bit] NOT NULL,
    CONSTRAINT [PK_S_User] PRIMARY KEY CLUSTERED
(
[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    CONSTRAINT [UK_ph4j8u4d8et9etejdr9mig3mr] UNIQUE NONCLUSTERED
(
[UserName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[S_User_Role]    Script Date: 2/9/2024 2:55:21 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[S_User_Role](
    [userid] [int] NOT NULL,
    [roleid] [int] NOT NULL,
    [id] [int] NOT NULL
) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[U_Class]    Script Date: 2/9/2024 2:55:21 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[U_Class](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Name] [nvarchar](max) NOT NULL,
    [MajorId] [int] NOT NULL,
    [Description] [nvarchar](max) NOT NULL,
    [SchoolId] [int] NOT NULL,
    [IsActive] [bit] NOT NULL,
    CONSTRAINT [PK_U_Class] PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[U_School]    Script Date: 2/9/2024 2:55:21 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[U_School](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [Name] [nvarchar](100) NOT NULL,
    [Description] [nvarchar](max) NOT NULL,
    [Location] [nvarchar](100) NOT NULL,
    [Phone] [varchar](100) NULL,
    [IsActive] [bit] NOT NULL,
    [Rule] [nvarchar](max) NULL,
    CONSTRAINT [PK_U_School2] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO

create table A_Curiculum
(
    Id         int,
    Name       int,
    SubjectId  int,
    SubMajorId int,
    [Order] int,
    Semester   int,
    CreatedAt  date default getdate()
)

go
CREATE TABLE [dbo].[A_Curiculum](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [SubjectId] [int] NOT NULL,
    [SubMajorId] [int] NOT NULL,
    [Semester] [int] NOT NULL,
    [CreatedAt] [date] NULL,
    CONSTRAINT [PK_A_Curiculum] PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[A_Subject]    Script Date: 2/27/2024 4:12:23 PM ******/


    USE [my-fap]
    GO
/****** Object:  Table [dbo].[U_Room]    Script Date: 2/9/2024 5:32:03 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[U_Room](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Name] [nvarchar](200) NOT NULL,
    [Description] [nvarchar](max) NOT NULL,
    [Building] [nvarchar](200) NOT NULL,
    [Type] [nvarchar](100) NOT NULL,
    [IsActive] [bit] NOT NULL,
    CONSTRAINT [PK_U_Room] PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[T_Slot]    Script Date: 2/19/2024 2:24:18 PM ******/

    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO

CREATE TABLE [dbo].[A_Subject](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [subjectCode] [nvarchar](50) NOT NULL,
    [name] [nvarchar](max) NOT NULL,
    [type] [nvarchar](max) NOT NULL,
    [status] [bit] NOT NULL,
    [description] [nvarchar](max) NOT NULL,
    [credits] [int] NOT NULL,
    [prerequisite] [nvarchar](10) NULL,
    [curiculumId] [int] NULL,
    CONSTRAINT [PK_A_Subject] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[A_Syllabus]    Script Date: 2/27/2024 4:12:23 PM ******/

CREATE TABLE [dbo].[T_Slot](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Name] [nvarchar](200) NOT NULL,
    [Description] [nvarchar](300) NOT NULL,
    [StartTime] [time](7) NOT NULL,
    [EndTime] [time](7) NOT NULL,
    [Order] [int] NOT NULL,
    [GroupId] [int] NOT NULL,
    CONSTRAINT [PK_T_Slot] PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[T_Group_Slot]    Script Date: 2/19/2024 4:40:58 PM ******/

    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO

CREATE TABLE [dbo].[A_Syllabus](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [StudentTasks] [nvarchar](max) NOT NULL,
    [Tools] [nvarchar](max) NOT NULL,
    [ScoringScale] [int] NOT NULL,
    [MinAvgMarkToPass] [int] NOT NULL,
    [ApprovedDate] [date] NOT NULL,
    [slot] [int] NOT NULL,
    [SubjectId] [int] NOT NULL,
    [IsActive] [bit] NOT NULL,
    CONSTRAINT [PK_A_Syllabus] PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
ALTER TABLE [dbo].[A_Curiculum] ADD  CONSTRAINT [DF__A_Curicul__Creat__09A971A2]  DEFAULT (getdate()) FOR [CreatedAt]
    GO

CREATE TABLE [dbo].[T_Group_Slot](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Name] [nvarchar](200) NOT NULL,
    [Description] [nvarchar](300) NOT NULL,
    CONSTRAINT [PK_T_Group_Slot] PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO

