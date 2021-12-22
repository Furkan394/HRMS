package kodlamaio.hrms.core.adapters.concretes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.adapters.abstracts.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploadAdapter implements ImageUploadService{
		
	Cloudinary cloudinary;
	
	@Autowired
	public ImageUploadAdapter() {
		
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				//(api-key)
		
	}
	
	@Override
	public DataResult<Map> upload(MultipartFile multipartFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}
}
