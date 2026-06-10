# Ejercicio 10 - Entrega

Alumno: Geromagnoli

Instrucciones mínimas para ejecutar y probar (local):

1) Base de datos
- Crear una base Postgres en Render (New → Postgres) o usar una existente.
- Copiar Hostname, Port, Database, Username, Password.

2) Configurar localmente
- Crear `src/main/resources/application.properties` con estos valores (NO subir este archivo):

  spring.datasource.url=jdbc:postgresql://<HOST_FULL>:5432/<DATABASE>?sslmode=require
  spring.datasource.username=<USERNAME>
  spring.datasource.password=<PASSWORD>
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

3) Ejecutar la app

```powershell
.\mvnw spring-boot:run
```

4) Endpoints a probar

- POST crear producto:

  ```powershell
  Invoke-RestMethod -Uri http://localhost:8080/api/productos -Method Post -ContentType 'application/json' -Body '{"nombre":"Prueba","valor":10.5}'
  ```

- GET listar productos:

  ```powershell
  Invoke-RestMethod -Uri http://localhost:8080/api/productos -Method Get
  ```

5) Subir a GitHub (resumen)

- Crear repositorio público en GitHub (ej: Ejercicio-10-Prog-4-).
- Desde la carpeta del proyecto:

  ```bash
  git init
  git add .
  git commit -m "Entrega TP - Ejercicio10 - Lopez Geronimo"
  git remote add origin https://github.com/Geromagnoli/Ejercicio-10-Prog-4-.git
  git branch -M main
  git push -u origin main
  ```

6) Comprobación de persistencia
- Si el POST devuelve el objeto creado y el GET lo muestra, los datos están en la DB.
- Para verificar directamente en la base (opcional) usar `psql` o DBeaver y ejecutar `SELECT * FROM producto;`.

Notas:
- No subas `application.properties` con credenciales reales. Mantén el archivo en tu máquina.
- Si necesitás, te ayudo a pushear el repo (necesito que ejecutes el `git push` si pide autenticación, o me pases un token seguro por un método privado).

