mkdir -p lib
curl -L https://github.com/typst/typst/releases/download/v0.15.1/typst-x86_64-unknown-linux-musl.tar.xz -o lib/typst.tar.xz
tar -xf lib/typst.tar.xz -C lib/