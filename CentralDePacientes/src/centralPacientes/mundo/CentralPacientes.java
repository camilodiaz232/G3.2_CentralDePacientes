/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clinica del Country");
        listaClinicas.add("Clinica Palermo");
        listaClinicas.add("Clinica Reina Sofia");
        listaClinicas.add("Clinica El Bosque");
        listaClinicas.add("Clinica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el m�todo que agrega al principio
        Integer indicePacienteConElCodigoDado = null;
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente pacienteActual = pacientes.get(i);
            if(pacienteActual.darCodigo() == pac.darCodigo()){
                indicePacienteConElCodigoDado = i;
            }
        }
        if(indicePacienteConElCodigoDado == null){
            pacientes.add(0, pac);
        }

    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agragar un paciente al final de la lista
        pacientes.add(pacientes.size(),pac);
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente antes del paciente con el c�digo dado
        Integer indicePacienteConElCodigoDado = null;
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente pacienteActual = pacientes.get(i);
            if(pacienteActual.darCodigo() == cod){
                indicePacienteConElCodigoDado = i;
            }
        }
        if(indicePacienteConElCodigoDado != null){
            pacientes.add(indicePacienteConElCodigoDado, pac);
        } else {
            throw new NoExisteException(cod);
        }

    }

    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente despues del paciente con el c�digo cod
        Integer indicePacienteConElCodigoDado = null;
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente pacienteActual = pacientes.get(i);
            if(pacienteActual.darCodigo() == cod){
                indicePacienteConElCodigoDado = i;
            }
        }
        if(indicePacienteConElCodigoDado != null){
            pacientes.add(indicePacienteConElCodigoDado+1, pac);
        } else {
            throw new NoExisteException(cod);
        }
    }

    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        // TODO: Completar el m�todo
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente pacienteActual = pacientes.get(i);
            if(pacienteActual.darCodigo() == codigo){
                return pacienteActual;
            }
        }
        return null;//no se encontró el paciente con el código recibido
    }

    /**
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el c�digo dado, genera la excepci�n
        Integer indicePacienteConElCodigoDado = null;
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente pacienteActual = pacientes.get(i);
            if(pacienteActual.darCodigo() == cod){
                indicePacienteConElCodigoDado = i;
            }
        }
        if(indicePacienteConElCodigoDado != null){
            pacientes.remove(indicePacienteConElCodigoDado);
        } else {
            throw new NoExisteException(cod);
        }
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de cl�nicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        // TODO: Completar
        int hombres = 0;
        for(int i = 0; i < pacientes.size();i ++){
            if (pacientes.get(i).darSexo()==Paciente.HOMBRE){
                hombres++;
            }
        }

        return hombres;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        // TODO: Completar
        int mujeres = 0;
        for(int i = 0; i < pacientes.size();i ++){
            if (pacientes.get(i).darSexo()==Paciente.MUJER){
                mujeres++;
            }
        }
        return mujeres;
    }

    /**
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
     */
    public String metodo4() {
        // TODO: Completar
        ArrayList<Integer> cantUsuarios = new ArrayList<>();
        for(int c = 0; c < listaClinicas.size(); c++){
            int cantidad = 0;
            for(int i = 0; i < pacientes.size();i ++){
                if (pacientes.get(i).darClinica().equals(listaClinicas.get(c))){
                    cantidad ++;
                }

            }
            cantUsuarios.add(cantidad);
        }
        int nMayor = cantUsuarios.get(0);
        int pMayor = 0;

        for (int l = 1; l<cantUsuarios.size(); l++){
            if(nMayor < cantUsuarios.get(l)){
                nMayor = cantUsuarios.get(l);
                pMayor = l;
            }
        }

        return listaClinicas.get(pMayor);
    }


}
