-- Consultas da aplicação
use gooFrete;

-- Pesquisa Transportador a partir do Veículo
select 
a.carrierName,
a.carrierCNPJCPF,
a.address,
a.district,
a.city,
a.state,
a.country,
a.zipcode,
a.phone, 
a.type 
from [carrier].[Carrier] a 
inner join [carrier].[Equipment] b on b.CarrierId = a.Id 
where b.Id = 'EquipmentId';

-- Pesquisa Veículo a partir do Transportador
select 
a.type, 
a.modelo, 
a.marca, 
a.eixos, 
a.licensePlate, 
b.CarrierName 
from [carrier].[Equipment] a
inner join [carrier].[Carrier] b on b.Id = a.CarrierId
where a.Id = 'CarrierId';
