import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cube
import eu.mihosoft.vrl.v3d.Transform
import eu.mihosoft.vrl.v3d.Vector3d
double d=15
double rot =80
//First create a point and a cube, the point representing a corner of the cube
Vector3d point = Vector3d.xyz(20,20, 0);

CSG cube  = new Cube(	point.x*2,// X dimention
			point.y*2,// Y dimention
			5//  Z dimention
			).toCSG()

println "Point starts at: "+point
// Make the transfomr of the first 2 moves
Transform frame2 = new Transform().rotz(-rot).movey(d)
//Apply the first motion to both the point and the cube
CSG cube2=cube.transformed(frame2)

Vector3d point2 = point.transformed(frame2)
println "Point2 starts at: "+point2+" from "+point
// Calculate the offset based on where the point ended up
double offseCalculated = -0.75*point2.getY()
println "Offset calculated "+offseCalculated
//Create the final frame by moveing by the calculated value
Transform frame3 = frame2.movey(offseCalculated)
// apply that final transform to the cube and return it, also apply the final frame to the 
// original point to get the final location
CSG cube3=cube.transformed(frame3)
Vector3d point3 = point.transformed(frame3)
println "Final location of the point "+point3


return cube3
	
	
	
