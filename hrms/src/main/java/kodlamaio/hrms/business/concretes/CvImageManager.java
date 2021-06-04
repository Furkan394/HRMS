package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvImageService;
import kodlamaio.hrms.core.adapters.abstracts.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvImageDao;
import kodlamaio.hrms.entities.concretes.CvImage;

@Service
public class CvImageManager implements CvImageService{
	
	private CvImageDao cvImageDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public CvImageManager(CvImageDao cvImageDao, ImageUploadService imageUploadService) {
		super();
		this.cvImageDao = cvImageDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public DataResult<List<CvImage>> getAll() {
		
		return new SuccessDataResult<List<CvImage>>(this.cvImageDao.findAll(),"Cv images listed.");
	}

	@Override
	public Result add(CvImage cvImage, MultipartFile multipartFile) {
		Map<String,String> uploadImage = this.imageUploadService.upload(multipartFile).getData();
		cvImage.setImageUrl(uploadImage.get("url"));
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Cv image added");
	}

}
