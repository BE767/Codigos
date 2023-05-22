/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocnic.dao.Helpers;

import java.io.Serializable;
import java.util.List;
import org.rocnic.dao.Usuarios;
import org.rocnic.dao.service.UsuariosService;

/**
 *
 * @author alumno
 */
public class UsuarioHelper extends Helpers<Usuarios> implements Serializable {

    private UsuariosService usuarioService;

    public UsuarioHelper() {
    }

    public boolean isValidaCamposOk()
    {
        return  isNotNullAndNotEmpity(t.getNombre());
    }
    
    

    @Override
    public boolean addT()
    {
      /*  usuarioService = new UsuariosService();
        t = new Usuarios();
        t.setIdPerfil(getParameter("descripcion"));
        t.setUsuario(getParameter("usuario"));
        t.setContraseña(getParameter("contraseña"));
        t.setBoleta(getParameter("boleta"));
        if (isValidaCamposOk()) {
            return rolService.addRol(t);
        }
        
        */
        return false;
    }
        
    /**
     *
     * @return
     */
    @Override
    public List<Usuarios> getListT() {
        usuarioService = new UsuariosService();
        return usuarioService.getUsuarioList();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean updateT() {
        usuarioService = new UsuariosService();
        t = new Usuarios();
        t.setIdPerfil(Integer.parseInt(getParameter("idp")));
        t.setUsuario(getParameter("usuario"));
        t.setContraseña(getParameter("contraseña"));
        t.setNombre(getParameter("nombre"));
        t.setBoleta(getParameter("boleta"));
        if (isValidaCamposOk()) {
            return usuarioService.updateUsuarios(t);
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean deleteT() {
        usuarioService = new UsuariosService();
        t = new Usuarios();
         t.setIdUsuario(Integer.parseInt(getParameter("idu")));
        if ( t.getIdUsuario() > 0) {
            return usuarioService.deleteUsuario(t);
        }
        return false;

    }

    @Override
    public Usuarios getTByKey() {
        String rol = null;

        rol = getParameter("rol");
        if (rol == null || rol.length() <= 0) {
            return null;
        }
        usuarioService = new UsuariosService();
        return usuarioService.getUsuariosByUsuarios(rol);
    }

}
