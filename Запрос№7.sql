Use Theater;
explain select Director.director_id as director, Performance_type.performance_type as performance_types,
(select count(Actors.actors_id) 
from Actors
join Roles on Roles.actor_id = Actors.actors_id
join Team_performance on Team_performance.role_id = Roles.role_id
join Performance on Performance.performance_id = Team_performance.performance_id
join Performance_type on Performance.performance_type_id = Performance_type.performance_type_id 
join Production on Performance.production_id = Production.production_id
join Director on Director.director_id = Production.director_id
where Director.director_id = director and
Performance_type.performance_type = performance_types) as countActors
from Performance_type join Director
