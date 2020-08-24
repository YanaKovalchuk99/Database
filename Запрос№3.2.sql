Use Theater;
select Count(performance_id) as PerformanceCount, performance_name
from Performance p join Production pr on p.production_id = pr.production_id
group by pr.production_id