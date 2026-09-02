-- 코드를 입력하세요
SELECT 
    c.car_id,
    c.car_type,
    FLOOR(30 * c.daily_fee * (100 - p.discount_rate) / 100) AS fee
FROM car_rental_company_car c
JOIN car_rental_company_discount_plan p
    ON c.car_type = p.car_type
    AND p.duration_type = '30일 이상'
WHERE c.car_type IN ('세단', 'suv')
    AND NOT EXISTS (
        SELECT 1
        FROM car_rental_company_rental_history h
        WHERE c.car_id = h.car_id
            AND h.start_date <= '2022-11-30'
            AND h.end_date >= '2022-11-01'
    )
    AND 30 * c.daily_fee * (100 - p.discount_rate) / 100 >= 500000
    AND 30 * c.daily_fee * (100 - p.discount_rate) / 100 < 2000000
ORDER BY
    fee DESC,
    c.car_type ASC,
    c.car_id DESC;
