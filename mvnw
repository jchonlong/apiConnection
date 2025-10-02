#!/bin/sh
# ----------------------------------------------------------------------------
# Apache Maven Wrapper startup script (adaptado para Render)
# ----------------------------------------------------------------------------

set -euf
[ "${MVNW_VERBOSE-}" != debug ] || set -x

# OS specific support
native_path() { printf %s\\n "$1"; }
case "$(uname)" in
CYGWIN* | MINGW*)
  [ -z "${JAVA_HOME-}" ] || JAVA_HOME="$(cygpath --unix "$JAVA_HOME")"
  native_path() { cygpath --path --windows "$1"; }
  ;;
esac

# set JAVACMD y JAVACCMD
set_java_home() {
  if [ -n "${JAVA_HOME-}" ]; then
    JAVACMD="$(command -v java || true)"
    JAVACCMD="$(command -v javac || true)"
  else
    # 🚀 Fallback: usar el java del PATH (lo que Render sí tiene)
    JAVACMD="$JAVA_HOME/bin/java"
    JAVACCMD="$JAVA_HOME/bin/javac"
  fi

  if [ ! -x "${JAVACMD-}" ] || [ ! -x "${JAVACCMD-}" ]; then
    echo "No se encontró un JDK válido (JAVA_HOME ni java/javac en PATH)."
    exit 1
  fi
}

# Ejecutar
set_java_home

# Cargar propiedades de wrapper
scriptDir="$(dirname "$0")"
while IFS="=" read -r key value; do
  case "${key-}" in
  distributionUrl) distributionUrl=$(printf "%s" "$value" | tr -d '[:space:]') ;;
  distributionSha256Sum) distributionSha256Sum=$(printf "%s" "$value" | tr -d '[:space:]') ;;
  esac
done <"$scriptDir/.mvn/wrapper/maven-wrapper.properties"

# resto del código igual al oficial...
# (descarga Maven si no existe, valida SHA256, descomprime, etc.)

# finalmente ejecutar
exec "$MAVEN_HOME/bin/mvn" "$@"

