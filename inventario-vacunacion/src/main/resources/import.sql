INSERT INTO public.usuario
(usuario_id, apellido, cedula, correo, direccion_domicilio, estado_vacuncacion, fecha_nacimiento, nombre, nombre_usuario, "password", telefono_movil, role_id)
VALUES(1, 'kazma', '0503209694', 'eddys@gmail.com', 'Latacunga', true, '1995-09-10 19:00:00.000', 'king', 'king_kazma', '12345', '0998219754', NULL);
INSERT INTO public.usuario
(usuario_id, apellido, cedula, correo, direccion_domicilio, estado_vacuncacion, fecha_nacimiento, nombre, nombre_usuario, "password", telefono_movil, role_id)
VALUES(2, 'Gomez', '0503209694', 'gomez@gmail.com', 'Salcedo', true, '1994-09-10 19:00:00.000', 'Pedro', 'Pedro_Gomez', '12345', '09954687', NULL);
INSERT INTO public.usuario
(usuario_id, apellido, cedula, correo, direccion_domicilio, estado_vacuncacion, fecha_nacimiento, nombre, nombre_usuario, "password", telefono_movil, role_id)
VALUES(3, 'Cajas', '0403206598', 'cajas@gmail.com', 'Salcedo', false, '1994-09-10 19:00:00.000', 'Juan', 'Juan_Cajas', '12345', '09954687', NULL);
INSERT INTO public.usuario
(usuario_id, apellido, cedula, correo, direccion_domicilio, estado_vacuncacion, fecha_nacimiento, nombre, nombre_usuario, "password", telefono_movil, role_id)
VALUES(4, 'SALINAS', '0403206598', 'salina@gmail.com', 'Salcedo', false, '1994-09-10 19:00:00.000', 'PEDRO', 'PEDRO_SALINAS', '12345', '09954687', NULL);
INSERT INTO public.usuario
(usuario_id, apellido, cedula, correo, direccion_domicilio, estado_vacuncacion, fecha_nacimiento, nombre, nombre_usuario, "password", telefono_movil, role_id)
VALUES(5, 'IDALGO', '0403206598', 'idalgo@gmail.com', 'Salcedo', false, '1994-09-10 19:00:00.000', 'DANIEL', 'DANIEL_IDALGO', '12345', '09954687', NULL);
INSERT INTO public.vacuna
(vacuna_id, nombre_vacuna)
VALUES(4, 'Pfizer');
INSERT INTO public.vacuna
(vacuna_id, nombre_vacuna)
VALUES(1, 'Sputnik');
INSERT INTO public.vacuna
(vacuna_id, nombre_vacuna)
VALUES(2, 'AstraZeneca');
INSERT INTO public.vacuna
(vacuna_id, nombre_vacuna)
VALUES(3, 'Jhonson&Jhonson');
INSERT INTO public.usuario_vacuna
(id, dosis, fecha_vacunacion, usuario_id, vacuna_id)
VALUES(1, 3, '2023-11-03 19:00:00.000', 1, 3);
INSERT INTO public.usuario_vacuna
(id, dosis, fecha_vacunacion, usuario_id, vacuna_id)
VALUES(3, 3, '2023-12-03 19:00:00.000', 4, 1);
INSERT INTO public.rol
(rol_id, nombre_rol)
VALUES(1, 'Admin');
INSERT INTO public.rol
(rol_id, nombre_rol)
VALUES(2, 'Empleado');



