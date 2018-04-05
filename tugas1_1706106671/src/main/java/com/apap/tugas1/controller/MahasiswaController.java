package com.apap.tugas1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.MahasiswaModel;
import com.apap.tugas1.service.MahasiswaService;
import com.apap.tugas1.service.ProgramStudiService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class MahasiswaController {
	
	@Autowired
	MahasiswaService mahasiswaDAO;
	@Autowired
	ProgramStudiService programStudiDAO;
	
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
	
	@GetMapping("/mahasiswa/tambah")
    public String tambah (Model model)
    {
		model.addAttribute("title","Tambah Mahasiswa");
		model.addAttribute("formTitle","Tambah Mahasiswa");
		model.addAttribute("mahasiswa",new MahasiswaModel());
		model.addAttribute("action_path","/mahasiswa/tambah");
		return "form";
    }
	

	@PostMapping("/mahasiswa/tambah")
    public String tambahSubmit (Model model, @ModelAttribute MahasiswaModel mahasiswa)
    {
		model.addAttribute("title","Tambah Mahasiswa");
		
		log.info(String.valueOf(mahasiswa.getId_prodi()));
		mahasiswa.setProgram_studi(programStudiDAO.selectProgramStudi((mahasiswa.getId_prodi())));
		mahasiswa.generateNpmWithoutCounter();
		mahasiswa.addCounterToNpm(mahasiswaDAO.selectLastCounterNpm(mahasiswa.getNpm_without_counter()+"%"));
		mahasiswa.setStatus("Aktif");
		mahasiswaDAO.insertMahasiswa(mahasiswa);
		
		model.addAttribute("npm",mahasiswa.getNpm());
		model.addAttribute("is_new",true);
		return "form-result";
    }
	

    @GetMapping("/mahasiswa/ubah/{npm}")
    public String ubahMahasiswa (Model model,  @PathVariable(value = "npm") String npm)
    {
		model.addAttribute("title","Ubah Mahasiswa");
		model.addAttribute("formTitle","Ubah Mahasiswa");
    		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);
    		model.addAttribute("mahasiswa",mahasiswa);
    		model.addAttribute("action_path","/mahasiswa/ubah/"+npm);
    		
    		return "form";
    }
    
    @PostMapping("/mahasiswa/ubah/{npm}")
    public String ubahMahasiswaPost (Model model,  @PathVariable(value = "npm") String npm, @ModelAttribute MahasiswaModel mahasiswa)
    {
		model.addAttribute("title","Ubah Mahasiswa");
		log.info(String.valueOf(mahasiswa.getId_prodi()));
		mahasiswa.setProgram_studi(programStudiDAO.selectProgramStudi((mahasiswa.getId_prodi())));
		mahasiswa.generateNpmWithoutCounter();
		mahasiswa.addCounterToNpm(mahasiswaDAO.selectLastCounterNpm(mahasiswa.getNpm_without_counter()+"%"));
		mahasiswaDAO.updateMahasiswa(mahasiswa);
		
		model.addAttribute("npm",npm);
		model.addAttribute("is_new",false);
		return "form-result";
    }
}
