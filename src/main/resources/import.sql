INSERT INTO estudiante (
    estu_id, 
    estu_nombre, 
    estu_apellido, 
    estu_genero, 
    estu_fecha_nacimiento
) 
VALUES (nextval('seq_estudiante'),
 'Juan', 
 'Jose', 
 'Masculino', 
 '2000-12-12'
 );