package oim;

import java.util.Properties;

import com.alibaba.druid.filter.config.ConfigTools;

public class TestMain
{

	public static void main(String[] args)
	{
		Properties pros = System.getProperties();
		
		String publickey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKh2RcuqTG1iz11iQQltJbPSCESdisDCmFfvZDIfPhX1PXwK2e1ddjOGcWvEQYZnp2T+Z/nPdfwrUgE3hJwLq3cCAwEAAQ==";
		String password = "Jr4XyL5HaCTjd/2xqqf2Psch0+2dHegKXGyFLlMxTW3j6MhT6+2VHWCldfs28hH8pWRYFpwsTCCS2ItTvUZl3g==";   

		try
		{
			System.out.println(ConfigTools.decrypt(publickey, password) );
			
			System.out.println(ConfigTools.encrypt("Huawei12#$"));
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
