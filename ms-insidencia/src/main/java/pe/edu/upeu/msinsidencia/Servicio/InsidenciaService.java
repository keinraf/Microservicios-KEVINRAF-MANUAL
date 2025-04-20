package pe.edu.upeu.msinsidencia.Servicio;

import pe.edu.upeu.msinsidencia.Entidad.Insidencia;

import java.util.List;

// ===========================================
// INTERFAZ DE SERVICIO PARA INSIDENCIA
// ===========================================

// Esta interfaz define el contrato que debe implementar cualquier clase
// que maneje la lógica de negocio relacionada con la entidad Insidencia.
public interface InsidenciaService {

    // =========================================
    // LISTAR TODAS LAS INSIDENCIAS
    // =========================================
    // Devuelve una lista completa de todas las insidencias registradas
    List<Insidencia> Listar();

    // =========================================
    // BUSCAR INSIDENCIA POR ID
    // =========================================
    // Devuelve una insidencia específica dado su ID
    Insidencia Buscar(Long id);

    // =========================================
    // GUARDAR NUEVA INSIDENCIA
    // =========================================
    // Guarda una nueva insidencia en la base de datos
    Insidencia Guardar(Insidencia insidencia);

    // =========================================
    // ACTUALIZAR INSIDENCIA EXISTENTE
    // =========================================
    // Actualiza los datos de una insidencia ya existente
    Insidencia Actualizar(Insidencia insidencia);

    // =========================================
    // ELIMINAR INSIDENCIA
    // =========================================
    // Elimina una insidencia del sistema
    Insidencia Eliminar(Insidencia insidencia);
}
