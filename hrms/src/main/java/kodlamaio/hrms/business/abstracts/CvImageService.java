package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvImage;

public interface CvImageService {
	DataResult<List<CvImage>> getAll();
	Result add(CvImage cvImage, MultipartFile multipartFile);
}
