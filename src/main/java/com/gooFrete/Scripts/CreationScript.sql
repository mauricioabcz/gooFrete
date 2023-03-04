-- Cria Banco
create database gooFrete;
use gooFrete;

-- Cria Schemas
create schema auth;
create schema emit;
create schema config;
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