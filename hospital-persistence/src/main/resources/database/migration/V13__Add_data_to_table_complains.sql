UPDATE complains SET
treatment = 'Treatment 1 was prescribed',
date_start = '2021-05-22',
date_complete = '2021-06-30',
result_treatment = 'dead'
WHERE complain_id = 1;

UPDATE complains SET
treatment = 'Treatment 2 was prescribed',
date_start = '2022-01-05',
date_complete = '2022-02-20',
result_treatment = 'alive'
WHERE complain_id = 2;

UPDATE complains SET
treatment = 'Treatment 3 was prescribed',
date_start = '2022-01-30',
date_complete = '2022-02-01',
result_treatment = 'alive'
WHERE complain_id = 3;