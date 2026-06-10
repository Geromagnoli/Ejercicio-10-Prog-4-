# Ejercicio 10 - Configuración y entrega

Breve guía para preparar el proyecto antes de entregar en GitHub.

1) Crear la base de datos en Render
- Entrar a https://render.com → New + → PostgreSQL → elegir plan Free.
- Copiar los datos de `Hostname`, `Database`, `Username`, `Password` (Connections).

2) Configurar el proyecto localmente
- Crear `src/main/resources/application.properties` con los datos de Render (no subir este archivo al repo).
- Ejemplo de propiedades (usar tu Host/DB/user/password):

  spring.datasource.url=jdbc:postgresql://<HOST>:5432/<DATABASE>
  spring.datasource.username=<USERNAME>
  spring.datasource.password=<PASSWORD>
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

3) Ejecutar la aplicación localmente
- En Windows (PowerShell):

```powershell
# Ejecutar con el wrapper de maven
.\mvnw spring-boot:run
```

4) Probar endpoints (ejemplos)
- POST (crear producto):

```bash
curl -X POST http://localhost:8080/api/productos -H "Content-Type: application/json" -d '{"nombre":"Prueba","valor":10.5}'
```

- GET (listar productos):

```bash
curl http://localhost:8080/api/productos
```

5) Inicializar Git y subir al repositorio público
- Inicializar repo y añadir remoto:

```bash
git init
git add .
git commit -m "Entrega: ejercicio10 configurado"
git remote add origin <URL_DE_TU_REPO>
git branch -M main
git push -u origin main
```

6) Notas de seguridad
- Evitá subir `src/main/resources/application.properties` con credenciales reales. Usa variables de entorno o archivos de configuración no incluidos en Git.

Si querés, puedo:
- Ignorar `application.properties` y crear la plantilla `application.properties.template`.
- Inicializar `git` aquí y configurar el `remote` si me das la URL.
- Reemplazar la configuración del `pom.xml` a Spring Boot 3.x y Java 17 si la consigna lo exige estrictamente.
