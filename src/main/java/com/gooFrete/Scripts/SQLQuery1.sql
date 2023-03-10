use gooFrete

select * from gooFrete.[carrier].[Carrier] order by CarrierName

select * from gooFrete.[carrier].Equipment

insert into gooFrete.[carrier].[Carrier]
values
(newid(),carrierName,carrierCNPJCPF,address,district,city,state,country,zipcode,type,getdate());

update [carrier].[Equipment]
set
type = 'Caminhão', modelo = 'SHC-500', marca = 'Scania', eixos = '6', licensePlate = 'Caminhão', carrierId = 6023E88B-00FD-4537-A422-633F69D6862E where id in ( 'BA03FCB2-E226-410A-AC6C-A38996942986');
select carrierName,carrierCNPJCPF,address,district,city,state,country,zipcode,phone,type from [carrier].[Carrier]

select a.type, a.modelo, a.marca, a.eixos, a.licensePlate, b.CarrierName from [carrier].[Equipment] a
inner join [carrier].[Carrier] b on b.Id = a.CarrierId

insert into gooFrete.[carrier].[Equipment]
values
(newid(),'Caminhão','SHC-500','Scania',6,'BR-550-990','6023E88B-00FD-4537-A422-633F69D6862E',getdate());

select a.carrierName,a.carrierCNPJCPF,a.address,a.district,a.city,a.state,a.country,a.zipcode,a.phone, a.type from [carrier].[Carrier] a
inner join [carrier].[Equipment] b on b.CarrierId = a.Id
order by carrierName

select a.carrierName,a.carrierCNPJCPF,a.address,a.district,a.city,a.state,a.country,a.zipcode,a.phone, a.type from [carrier].[Carrier] a inner join [carrier].[Equipment] b on b.CarrierId = a.Id where b.Id = 'D9F38D3A-6700-4733-B004-208915A2B507';
