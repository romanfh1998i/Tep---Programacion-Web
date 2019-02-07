package com.tep.pucmm.ValoracionComputadora.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Roman on 17/11/18.
 */
@Service
public class CorreoService {
    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void enviarCorreo(SimpleMailMessage email){
        mailSender.send(email);
    }
}
