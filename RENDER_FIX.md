# 🔧 Solución al Error: "yarn start" en Render

Render está intentando ejecutar `yarn start` porque detectó el proyecto como Node.js. Necesitas cambiar la configuración a Docker.

## ⚡ Solución Rápida (5 minutos)

### Paso 1: Editar el Servicio en Render

1. Ve a [Render Dashboard](https://dashboard.render.com)
2. Encuentra tu servicio `evo-app` (o el nombre que le diste)
3. Haz clic en el nombre del servicio para abrirlo

### Paso 2: Ir a Settings

1. En el menú lateral, haz clic en **"Settings"**
2. Desplázate hasta la sección **"Build & Deploy"**

### Paso 3: Cambiar Environment a Docker

**IMPORTANTE:** Busca la opción **"Environment"** y cámbiala a:

```
Docker
```

**NO** uses:
- ❌ Node
- ❌ Maven  
- ❌ Java
- ✅ **Docker** ← Este es el correcto

### Paso 4: Configurar Build y Start Commands

En la misma sección, busca:

- **Build Command:** Deja este campo **COMPLETAMENTE VACÍO**
- **Start Command:** Deja este campo **COMPLETAMENTE VACÍO**

**NO** pongas nada como `mvn clean install` o `java -jar`. Déjalos vacíos.

### Paso 5: Configurar Dockerfile

Busca la sección **"Docker"** o **"Dockerfile"**:

- **Dockerfile Path:** `Dockerfile` (o `./Dockerfile`)
- **Docker Context:** `.` (un punto, significa la raíz)

### Paso 6: Guardar y Redesplegar

1. Haz clic en **"Save Changes"** al final de la página
2. Render comenzará automáticamente a reconstruir el servicio
3. Ve a la pestaña **"Logs"** para ver el progreso

## ✅ Verificación

Después de guardar, en los logs deberías ver algo como:

```
==> Building Docker image...
==> Running 'docker build -t render-xxx /opt/render/project/src'
==> Starting container...
==> Running 'java -jar app.jar'
```

**NO** deberías ver:
```
==> Running 'yarn start'  ❌
```

## 🆘 Si No Funciona

### Opción A: Eliminar y Recrear el Servicio

1. Elimina el servicio actual
2. Crea un nuevo **"Web Service"**
3. Conecta tu repositorio: `tino77avu/Evo`
4. **Inmediatamente** en la configuración inicial:
   - Selecciona **"Docker"** como Environment
   - Deja Build Command y Start Command vacíos
   - Dockerfile Path: `Dockerfile`
5. Crea el servicio

### Opción B: Verificar el Root Directory

En Settings, verifica que:
- **Root Directory:** Esté vacío o sea `.`
- **NO** sea `src` o cualquier otra carpeta

### Opción C: Verificar el Dockerfile

Asegúrate de que el Dockerfile esté en la raíz del repositorio:
- ✅ `Evolucion/Dockerfile` (correcto)
- ❌ `Evolucion/src/Dockerfile` (incorrecto)

## 📸 Capturas de Pantalla de Referencia

En Render, la configuración debería verse así:

```
Environment: [Docker ▼]
Build Command: [vacío]
Start Command: [vacío]
Dockerfile Path: Dockerfile
Docker Context: .
```

## 🔍 Verificar en GitHub

Asegúrate de que el Dockerfile esté en GitHub:
1. Ve a: https://github.com/tino77avu/Evo
2. Verifica que veas el archivo `Dockerfile` en la raíz
3. Si no está, haz push de los cambios

## 💡 Nota Importante

Render a veces "recuerda" la configuración anterior. Si cambias a Docker pero sigue intentando usar yarn, intenta:
1. Guardar los cambios
2. Esperar a que falle el deploy
3. Hacer un "Manual Deploy" desde la pestaña "Manual Deploy"
4. O eliminar y recrear el servicio completamente
