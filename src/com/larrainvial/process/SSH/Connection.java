package com.larrainvial.process.SSH;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import com.larrainvial.logviewer.model.ModelXml;
import com.larrainvial.process.vo.ServerVO;
import org.apache.log4j.Logger;
import java.util.logging.Level;

public class Connection {

    private static Logger logger = Logger.getLogger(Connection.class.getName());

    public Session connectServer(ModelXml xmlVO) {

        Session session = null;

        try {

            JSch jSSH = new JSch();
            session = jSSH.getSession(xmlVO.userServer, xmlVO.nameServer, 22);
            UserInfo ui = new SesionUsuario(xmlVO.passServer, null);
            session.setUserInfo(ui);
            session.setPassword(xmlVO.passServer);

        } catch (Exception ex) {
            logger.error(Level.SEVERE, ex);
        }

        return session;

    }

    public Session connectServer(ServerVO serverVO) {

        Session session = null;

        try {

            JSch jSSH = new JSch();
            session = jSSH.getSession(serverVO.usuario, serverVO.url, 22);
            UserInfo ui = new SesionUsuario(serverVO.pass, null);
            session.setUserInfo(ui);
            session.setPassword(serverVO.pass);

        } catch (Exception ex) {
            logger.error(Level.SEVERE, ex);
        }

        return session;

    }
}



