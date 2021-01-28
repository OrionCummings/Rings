# PowerShell script to auto generate files for the Rings mod.
# As of now it only creates the ITEM.json file

$name = "calcite"
$file = ".json"
$full_name = -join($name, $file)
$base_path = "D:\Minecraft Mods\Rings\src\main\resources\assets\rings\models\item\"
$item_path = -join($base_path, $full_name)

$item_file_exists = Test-Path $item_path

if($item_file_exists){
	Write-Host "File exists! Not creating nor overwriting file"
	exit
}

Write-Host "No such file exists! Creating new file"
New-Item $item_path

$layer_path = "rings:items/"
$layer_path = -join($layer_path, $name)
Write-Host $layer_path

$json = @()
$sub_info = "" | Select-Object layer0
$sub_info.layer0 = $layer_path

$info = "" | Select-Object parent,textures
$info.parent = "item/generated"
$info.textures = $sub_info

$json += $info
$json | ConvertTo-Json | Out-File $item_path

exit
