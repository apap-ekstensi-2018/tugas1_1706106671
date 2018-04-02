package com.apap.tugas1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.MahasiswaModel;
import com.apap.tugas1.service.MahasiswaService;

@Controller
public class MahasiswaController {
	
	@Autowired
	MahasiswaService mahasiswaDAO;
	
	@RequestMapping("/")
    public String index (Model model)
    {
    		model.addAttribute("title","Home");
        return "index";
    }
	
	@RequestMapping("/mahasiswa")
    public String view (Model model,
            @RequestParam(value = "npm", required = false) String npm)
    {
    		
        MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);

		model.addAttribute("title","Detail Mahasiswa");
        if (mahasiswa != null) {
            model.addAttribute ("mahasiswa", mahasiswa);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }
}
