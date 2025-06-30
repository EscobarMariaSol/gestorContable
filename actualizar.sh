#!/bin/bash

echo "🧹 Limpiando proyecto..."
./mvnw clean

echo "🔨 Compilando y construyendo..."
./mvnw package

echo "📁 Verificando archivos HTML en target..."
find target/classes/static -name "*.html"

echo "✅ Proyecto actualizado. Reiniciá el servidor si es necesario."
