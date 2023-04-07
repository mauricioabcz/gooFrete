-- Cria Banco
create database gooFrete;
use gooFrete;

-- Cria Schemas
create schema auth;
create schema emit;
create schema carrier;

-- Cria Tabelas
/****** Object:  Table [carrier].[Carrier]    Script Date: 03/03/2023 20:22:32 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [carrier].[Carrier](
	[Id] [uniqueidentifier] NOT NULL,
	[CarrierName] [varchar](50) NOT NULL,
	[CarrierCNPJCPF] [varchar](50) NOT NULL,
	[Address] [varchar](50) NOT NULL,
	[District] [varchar](50) NOT NULL,
	[City] [varchar](50) NOT NULL,
	[State] [varchar](50) NOT NULL,
	[Country] [varchar](50) NOT NULL,
	[ZIPCode] [varchar](50) NOT NULL,
	[Type] [int] NOT NULL,
	[InsertDate] [datetime] NOT NULL,
 CONSTRAINT [PK_Carrier] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [carrier].[Equipment]    Script Date: 04/03/2023 22:13:32 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [carrier].[Equipment](
	[Id] [uniqueidentifier] NOT NULL,
	[Type] [varchar](50) NOT NULL,
	[Modelo] [varchar](50) NOT NULL,
	[Marca] [varchar](50) NOT NULL,
	[Eixos] [int] NOT NULL,
	[LicensePlate] [varchar](50) NOT NULL,
	[CarrierId] [uniqueidentifier] NOT NULL,
	[InsertDate] [datetime] NOT NULL,
 CONSTRAINT [PK_Equipment] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [carrier].[Equipment]  WITH CHECK ADD  CONSTRAINT [FK_Equipment_Carrier] FOREIGN KEY([CarrierId])
REFERENCES [carrier].[Carrier] ([Id])
GO

ALTER TABLE [carrier].[Equipment] CHECK CONSTRAINT [FK_Equipment_Carrier]
GO

USE [gooFrete]
GO

/****** Object:  Table [emit].[Travel]    Script Date: 06/04/2023 09:35:04 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [emit].[Travel](
	[Id] [uniqueidentifier] NOT NULL,
	[Identification] [varchar](50) NOT NULL,
	[CarrierId] [uniqueidentifier] NOT NULL,
	[CarrierName] [varchar](50) NULL,
	[CarrierCNPJCPF] [varchar](50) NULL,
	[Valor] [decimal](18, 2) NOT NULL,
	[Distancia] [decimal](18, 2) NOT NULL,
	[Duracao] [decimal](18, 2) NOT NULL,
	[qtdePracas] [int] NOT NULL,
	[EquipmentId] [uniqueidentifier] NULL,
	[InsertDate] [datetime] NULL,
 CONSTRAINT [PK_Travel] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [emit].[Travel]  WITH CHECK ADD  CONSTRAINT [FK_Travel_Carrier] FOREIGN KEY([CarrierId])
REFERENCES [carrier].[Carrier] ([Id])
GO

ALTER TABLE [emit].[Travel] CHECK CONSTRAINT [FK_Travel_Carrier]
GO

ALTER TABLE [emit].[Travel]  WITH CHECK ADD  CONSTRAINT [FK_Travel_Equipment] FOREIGN KEY([EquipmentId])
REFERENCES [carrier].[Equipment] ([Id])
GO

ALTER TABLE [emit].[Travel] CHECK CONSTRAINT [FK_Travel_Equipment]
GO

USE [gooFrete]
GO
