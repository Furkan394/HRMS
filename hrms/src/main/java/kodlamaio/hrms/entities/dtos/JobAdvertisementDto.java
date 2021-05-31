package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {
	
	private String companyName;
	private String title;
	private int numberOfOpenPositions;
	private LocalDate postedDate;
	private LocalDate applicationDeadline;
}
