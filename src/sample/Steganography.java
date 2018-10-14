package sample;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;

public class Steganography {

    public void encode(String path, String original, String ext1, String stegan, String message) {
        String file_name = original;
        //BufferedImage image_orig = file_name;

//user space is not necessary for Encrypting
    /*    BufferedImage image = user_space(image_orig);
        image = add_text(image, message);

        return (setImage(image, new File(image_path(path, stegan, "png")), "png"));*/
    }

    private BufferedImage user_space(BufferedImage image) {

//create new_img with the attributes of image
        BufferedImage new_img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = new_img.createGraphics();
        graphics.drawRenderedImage(image, null);
        graphics.dispose(); //release all allocated memory for this image
        return new_img;
    }

    private byte[] get_byte_data(BufferedImage image) {
        WritableRaster raster = image.getRaster();
        DataBufferByte buffer = (DataBufferByte) raster.getDataBuffer();
        return buffer.getData();
    }

    private byte[] bit_conversion(int i) {

//only using 4 bytes
        byte byte3 = (byte) ((i & 0xFF000000) >>> 24); //0
        byte byte2 = (byte) ((i & 0x00FF0000) >>> 16); //0
        byte byte1 = (byte) ((i & 0x0000FF00) >>> 8); //0
        byte byte0 = (byte) ((i & 0x000000FF));
//{0,0,0,byte0} is equivalent, since all shifts >=8 will be 0
        return (new byte[]{byte3,byte2, byte1, byte0});
    }

   /* private byte[] encode_text(byte[] image, byte[] addition, int offset) {
//check that the data + offset will fit in the image
        if (addition.length + offset > image.length) {
            throw new IllegalArgumentException("File not long enough!");
        }
//loop through each addition byte
        for (int i = 0; i < addition.length; ++i) { //loop through the 8 bits of each byte int add = addition[i]; for (int bit = 7; bit >= 0; --bit, ++offset)
            {
                int b = (addition >>> bit) & 1;

                image[offset] = (byte) ((image[offset] & 0xFE) | b);
            }
        }
        return image;
    }*/

    private byte[] decode_text(byte[] image) {

        int length = 0;
        int offset = 32;
//loop through 32 bytes of data to determine text length
        for (int i = 0; i < 32; ++i) //i=24 will also work, as only the 4th byte contains real data
        {
            length = (length << 1) | (image[i] & 1);
        }
        byte[] result = new byte[length];
//loop through each byte of text
        for (int b = 0; b < result.length; ++b) {
//loop through each bit within a byte of text
            for (int i = 0; i < 8; ++i, ++offset) {
//assign bit: [(new byte value) << 1] OR [(text byte) AND 1]
                result[b] = (byte) ((result[b] << 1) | (image[offset] & 1));
            }
        }
        return result;
    }

    private static String toBinary(byte b) {
        StringBuilder sb = new StringBuilder("00000000");
        for (int bit = 0; bit < 8; bit++) { if (((b >> bit) & 1) > 0) {
            sb.setCharAt(7 - bit, '1');
        }
        }
        return (sb.toString());
    }
}
